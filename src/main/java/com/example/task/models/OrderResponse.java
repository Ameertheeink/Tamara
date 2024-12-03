package com.example.task.models;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderResponse {
    @Getter
    @Setter
    private Long Id;
}