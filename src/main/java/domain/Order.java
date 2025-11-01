package com.company.orders.domain;

import com.company.orders.model.OrderStatus;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String customerName;

    // Guardamos items como colección simple de Strings
    @ElementCollection
    @CollectionTable(name = "order_items", joinColumns = @JoinColumn(name = "order_id"))
    @Column(name = "item")
    private List<String> items = new ArrayList<>();

    @NotNull
    private BigDecimal totalAmount;

    @Enumerated(EnumType.STRING)
    @NotNull
    private OrderStatus status;
}






