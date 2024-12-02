package com.example.task.models;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long Id;

    @Column(nullable = false)
    @NotNull
    private String order_item;

    @Column(nullable = false)
    @NotNull
    @Getter
    @Setter
    private double totalAmount;
    @Getter
    @Setter
    private double discountAmount;
    @Getter
    @Setter
    private double taxAmount;
}
