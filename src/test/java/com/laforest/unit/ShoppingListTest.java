package com.laforest.unit;

import com.laforest.ShoppingList;
import de.bechte.junit.runners.context.HierarchicalContextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static com.laforest.ProductType.BEAN;
import static com.laforest.ProductType.CUCUMBER;
import static java.math.BigDecimal.valueOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.comparesEqualTo;

@RunWith(HierarchicalContextRunner.class)
public class ShoppingListTest {

    private final ShoppingList shoppingList = new ShoppingList();

    public class Empty {

        @Test
        public void shouldRetrieveZero() {
            assertThat(valueOf(0), comparesEqualTo(shoppingList.totalPrice()));
        }

    }

    public class WithProducts {

        @Before
        public void setUp() {
            shoppingList.add(BEAN, valueOf(0.65));
            shoppingList.add(CUCUMBER, valueOf(2));
        }

        @Test
        public void shouldRetrieveTotalPrice() {
            assertThat(valueOf(2.65), comparesEqualTo(shoppingList.totalPrice()));
        }

    }

}
