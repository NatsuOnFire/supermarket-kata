package com.laforest;

import java.math.BigDecimal;

public class FreeProductPricingDecision implements PricingDecision {

    private final BigDecimal basePrice;
    private final int minimumQuantity;

    public FreeProductPricingDecision(BigDecimal basePrice, int minimumQuantity) {
        this.basePrice = basePrice;
        this.minimumQuantity = minimumQuantity;
    }

    public BigDecimal price(int quantity) {
        if (quantity >= minimumQuantity)
            return basePrice.multiply(BigDecimal.valueOf(quantity - 1));
        return basePrice.multiply(BigDecimal.valueOf(quantity));
    }

}
