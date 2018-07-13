package com.laforest.unit;

import com.laforest.*;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

@RunWith(HierarchicalContextRunner.class)
public class SuperMarketTest {

    private SuperMarket superMarket;
    private final Map<ProductType, PricingDecision> inventory = new HashMap<>();

    public class FixedPriceContext {

        @Before
        public void setUp() {
            inventory.put(ProductType.BEAN, new FixedPricingDecision(valueOf(0.65)));
            superMarket = new SuperMarket(inventory);
        }

        @Test
        public void shouldChargeOneProduct() {
            assertThat(valueOf(0.65), comparesEqualTo(charge(ProductType.BEAN, 1)));
        }

        @Test
        public void shouldChargeTwoProducts() {
            assertThat(valueOf(1.3), comparesEqualTo(charge(ProductType.BEAN, 2)));
        }

    }

    public class AcceptanceTest {

        @Before
        public void setUp() {
            inventory.put(ProductType.BEAN, new FixedPricingDecision(valueOf(0.65)));
            inventory.put(ProductType.CUCUMBER, new FreeProductPricingDecision(valueOf(0.80), 2));
            superMarket = new SuperMarket(inventory);
        }

        @Test
        public void shouldBeChargedAccordingToEachPricingDecision() {
            BigDecimal totalCharge = charge(ProductType.BEAN, 3).add(charge(ProductType.CUCUMBER, 3));
            assertThat(valueOf(3.55), comparesEqualTo(totalCharge));
        }


    }

    private BigDecimal charge(ProductType product, int quantity) {
        return superMarket.charge(product, quantity);
    }

}
