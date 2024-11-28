package com.example.task.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="orders")
public class Order {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long Id;

    @Column(nullable = false)
    @NotNull
    private String order_item;

    @Column(nullable = false)
    @NotNull
    private double total_amount;
    private double discount_amount;

    private double tax_amount;
}
