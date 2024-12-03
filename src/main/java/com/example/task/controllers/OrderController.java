package com.example.task.controllers;


import com.example.task.models.Order;
import com.example.task.models.OrderResponse;
import com.example.task.services.OrderService;
import com.example.task.util.ResponseMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/allorders")  //view all orders
    public ResponseEntity<List<Order>> getAllOrder() {
        List<Order> orders = orderService.getAllOrders();
        if (orders.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(orders);
    }

    @PostMapping("/add")   //add new order
    public ResponseEntity<OrderResponse> addOrder(@RequestBody Order order) {
        Order addOrder = orderService.addOrder(order);
        OrderResponse orderResponse = OrderResponse.builder().Id(addOrder.getId()).build();
        return ResponseEntity.status(HttpStatus.OK).body(orderResponse);

    }

    @GetMapping("/{id}")   // view order by order_id
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @PostMapping("/{id}/pay")  // pay for an order using id
    public ResponseEntity<?> payOrder(@PathVariable Long id) {
        try {
            ResponseEntity<String> response = restTemplate.postForEntity("https://httpbin.org/", null, String.class);

            return ResponseEntity.status(HttpStatus.CREATED).body(ResponseMessages.PAYMENT_SUCCESSFUL);
        } catch (Exception e) {
            return ResponseEntity.status((HttpStatus.SERVICE_UNAVAILABLE)).body(ResponseMessages.PAYMENT_FAILED);
        }
    }
}
/*
http://localhost:8080/api/orders/allorders   GET
http://localhost:8080/api/orders/2           GET
testing
*
* */