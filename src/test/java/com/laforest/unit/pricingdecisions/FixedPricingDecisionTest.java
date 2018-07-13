package com.laforest.unit.pricingdecisions;

import com.laforest.FixedPricingDecision;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class FixedPricingDecisionTest {

    @Test
    public void shouldChargeEachProductIndividually() {
        assertEqualPrices(valueOf(0.65), fixedPriceDecision(valueOf(0.65), 1));
        assertEqualPrices(valueOf(1.3), fixedPriceDecision(valueOf(0.65), 2));
    }

    private void assertEqualPrices(BigDecimal expectedPrice, BigDecimal actualPrice) {
        assertThat(expectedPrice, comparesEqualTo(actualPrice));
    }

    private BigDecimal fixedPriceDecision(BigDecimal baseProductPrice, int quantity) {
        return new FixedPricingDecision(baseProductPrice).price(quantity);
    }


}
