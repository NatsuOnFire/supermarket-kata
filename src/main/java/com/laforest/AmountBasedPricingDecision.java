package com.laforest;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;

public class AmountBasedPricingDecision implements PricingDecision {

    private final BigDecimal basePrice;
    private final int expectedQuantityForRefund;
    private final BigDecimal discountPrice;

    public AmountBasedPricingDecision(BigDecimal basePrice, int expectedQuantityForRefund, BigDecimal discountPrice) {
        this.basePrice = basePrice;
        this.expectedQuantityForRefund = expectedQuantityForRefund;
        this.discountPrice = discountPrice;
    }

    public BigDecimal price(int quantity) {
        if (quantity >= expectedQuantityForRefund)
            return discountPrice.multiply(valueOf(quantity / expectedQuantityForRefund))
                    .add(basePrice.multiply(valueOf(quantity % expectedQuantityForRefund)));
        return basePrice.multiply(valueOf(quantity));
    }

}
