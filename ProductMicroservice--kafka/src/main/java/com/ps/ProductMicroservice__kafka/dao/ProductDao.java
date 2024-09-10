package com.ps.ProductMicroservice__kafka.dao;

import lombok.*;

import java.math.BigDecimal;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductDao {

    private String productId;
    private String title;
    private BigDecimal price;
    private Integer quantity;
}
