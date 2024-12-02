package com.example.task.services;

import com.example.task.models.Order;
import com.example.task.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepo;

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    public Order addOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepo.findById(id).orElseThrow(() -> new RuntimeException("Order id not found"));
    }
}
