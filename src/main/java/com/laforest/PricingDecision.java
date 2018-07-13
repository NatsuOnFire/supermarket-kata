package com.laforest;

import java.math.BigDecimal;

public interface PricingDecision {

    BigDecimal price(int quantity);

}
