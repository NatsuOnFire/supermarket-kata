package com.laforest;

import java.math.BigDecimal;
import java.util.Map;

public class SuperMarket {

    private final Map<ProductType, PricingDecision> inventory;

    public SuperMarket(Map<ProductType, PricingDecision> inventory) {
        this.inventory = inventory;
    }

    public BigDecimal charge(ProductType productType, int quantity) {
        return inventory.get(productType).price(quantity);
    }

}
