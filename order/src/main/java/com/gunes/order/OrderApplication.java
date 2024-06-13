package com.gunes.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}

@RestController
@RequiredArgsConstructor
class OrderController {
    private final OrderService orderService;

    @PostMapping("orders")
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public void placeOrder(@RequestBody PlaceOrderRequest request) {
        this.orderService.placeOrder(request);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class PlaceOrderRequest {
    private String product;
    private double price;
}

@Service
@RequiredArgsConstructor
class OrderService {
    private final KafkaTemplate kafkaTemplate;
    private final OrderRepository orderRepository;

    public void placeOrder(PlaceOrderRequest request) {
        Order order = new Order();
        order.setPrice(request.getPrice());
        order.setProduct(request.getProduct());
        order.setStatus("PLACED");
        Order o = this.orderRepository.save(order);
        this.kafkaTemplate.send("prod.orders.placed", String.valueOf(o.getId()), OrderPlacedEvent.builder()
                .product(request.getProduct())
                .price(request.getPrice())
                .orderId(order.getId().intValue())
                .build());
    }
    @KafkaListener(topics = "prod.orders.shipped", groupId = "order-group")
    public void handleOrderShippedEvent(String orderId) {
        this.orderRepository.findById(Long.valueOf(orderId)).ifPresent(order -> {
            order.setStatus("SHIPPED");
            this.orderRepository.save(order);
        });
    }
}

@Data
@Builder
class OrderPlacedEvent {

    private int orderId;

    private String product;
    private double price;
}

interface OrderRepository extends CrudRepository<Order, Long> {

}

@Entity(name = "orders")
@Data
class Order {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long Id;

    private String product;
    private double price;
    private String status;
}