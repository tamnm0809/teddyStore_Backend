package com.backend.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiscountDTO {
    private BigDecimal price;
    private BigDecimal pricesale;

}
