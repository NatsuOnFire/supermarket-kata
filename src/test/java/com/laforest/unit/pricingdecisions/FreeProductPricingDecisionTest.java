package com.laforest.unit.pricingdecisions;

import com.laforest.FreeProductPricingDecision;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class FreeProductPricingDecisionTest {

    @Test
    public void shouldChargeEachProduct() {
        assertEqualPrices(valueOf(0.65), freeProductDecision(valueOf(0.65), 2, 1));
        assertEqualPrices(valueOf(0.65), freeProductDecision(valueOf(0.65), 2, 2));
        assertEqualPrices(valueOf(1.3), freeProductDecision(valueOf(0.65), 3, 2));
    }

    private void assertEqualPrices(BigDecimal expectedPrice, BigDecimal actualPrice) {
        assertThat(expectedPrice, comparesEqualTo(actualPrice));
    }

    private BigDecimal freeProductDecision(BigDecimal baseProductPrice, int minimumQuantityForRefund, int quantity) {
        return new FreeProductPricingDecision(baseProductPrice, minimumQuantityForRefund).price(quantity);
    }


}
