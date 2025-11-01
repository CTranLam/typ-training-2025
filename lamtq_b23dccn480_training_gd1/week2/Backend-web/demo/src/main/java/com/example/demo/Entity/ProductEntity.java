package com.example.demo.Entity;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ProductEntity {
    private long id;
    private String productName;
    private double price;
    private long quantity;
    private String description;
    private boolean isDeleted;
}
