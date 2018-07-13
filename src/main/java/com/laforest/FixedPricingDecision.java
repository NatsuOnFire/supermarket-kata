package com.laforest;

import java.math.BigDecimal;

public class FixedPricingDecision implements PricingDecision {

    private final BigDecimal basePrice;

    public FixedPricingDecision(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public BigDecimal price(int quantity) {
        return this.basePrice.multiply(BigDecimal.valueOf(quantity));
    }

}
