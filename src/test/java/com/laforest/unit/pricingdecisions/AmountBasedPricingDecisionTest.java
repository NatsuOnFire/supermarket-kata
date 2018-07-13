package com.laforest.unit.pricingdecisions;

import com.laforest.AmountBasedPricingDecision;
import org.junit.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

public class AmountBasedPricingDecisionTest {

    @Test
    public void shouldChargeEachProduct() {
        assertEqualPrices(valueOf(0.5), amountBasedPriceDecision(valueOf(0.5), 3, valueOf(1), 1));
        assertEqualPrices(valueOf(1), amountBasedPriceDecision(valueOf(0.5), 3, valueOf(1), 2));
        assertEqualPrices(valueOf(1), amountBasedPriceDecision(valueOf(0.5), 3, valueOf(1), 3));
        assertEqualPrices(valueOf(1.5), amountBasedPriceDecision(valueOf(0.5), 3, valueOf(1), 4));
        assertEqualPrices(valueOf(2), amountBasedPriceDecision(valueOf(0.5), 3, valueOf(1), 6));
        assertEqualPrices(valueOf(1), amountBasedPriceDecision(valueOf(0.5), 6, valueOf(1), 6));
    }

    private void assertEqualPrices(BigDecimal expectedPrice, BigDecimal actualPrice) {
        assertThat(expectedPrice, comparesEqualTo(actualPrice));
    }

    private BigDecimal amountBasedPriceDecision(BigDecimal baseProductPrice, int minimumQuantityForRefund,
                                                BigDecimal discountPrice, int quantity) {
        return new AmountBasedPricingDecision(baseProductPrice, minimumQuantityForRefund, discountPrice).price(quantity);
    }

}
