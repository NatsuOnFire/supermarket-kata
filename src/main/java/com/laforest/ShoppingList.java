package com.laforest;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.valueOf;

public class ShoppingList {

    private final HashMap<ProductType, BigDecimal> caddy = new HashMap<>();

    public void add(ProductType productType, BigDecimal price) {
        caddy.put(productType, price);
    }

    public BigDecimal totalPrice() {
        return caddy.entrySet().stream()
                .map(Map.Entry::getValue)
                .reduce(BigDecimal::add)
                .orElse(valueOf(0));
    }
}
