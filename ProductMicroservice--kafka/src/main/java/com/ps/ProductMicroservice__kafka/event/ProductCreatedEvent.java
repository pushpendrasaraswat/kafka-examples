package com.ps.ProductMicroservice__kafka.event;

import lombok.*;

import java.math.BigDecimal;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreatedEvent {
	
	private String productId;
	private String title;
	private BigDecimal price;
	private Integer quantity;
	
}
