package help_requests.discount_price;

import help_requests.discount_price.DoubleSolution.CartItem;
import org.junit.jupiter.api.Test;

import static help_requests.discount_price.DoubleSolution.getTotal;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DoubleSolutionTest {
    private static final double DELTA = 1e-10;

    @Test
    void testZeroItems() {
        CartItem[] cartItems = {};
        assertEquals(0.0, getTotal(cartItems, 1, 12), DELTA);
    }

    @Test
    void testOneItemDiscounted() {
        CartItem[] cartItems = {
                new CartItem(12, 2)
        };
        assertEquals(18.0, getTotal(cartItems, 2, 50), DELTA);
    }

    @Test
    void testNoItemDiscounted() {
        CartItem[] cartItems = {
                new CartItem(12, 2)
        };
        assertEquals(24.0, getTotal(cartItems, 3, 50), DELTA);
    }

    @Test
    void testMultipleItemDiscounted() {
        CartItem[] cartItems = {
                new CartItem(12, 13)
        };
        assertEquals(120.0, getTotal(cartItems, 2, 50), DELTA);
    }

    @Test
    void testZeroDiscount() {
        CartItem[] cartItems = {
                new CartItem(12, 2),
                new CartItem(13, 3),
        };
        assertEquals(63.0, getTotal(cartItems, 1, 0), DELTA);
    }

    @Test
    void testDiscountForOnlySecondItem() {
        CartItem[] cartItems = {
                new CartItem(100, 1),
                new CartItem(200, 1),
                new CartItem(300, 1),
        };
        assertEquals(550.0, getTotal(cartItems, 3, 50), DELTA);
    }

    @Test
    void testNoItemDiscountMultiple() {
        CartItem[] cartItems = {
                new CartItem(1, 2),
                new CartItem(2, 3),
                new CartItem(3, 4),
        };
        assertEquals(20.0, getTotal(cartItems, 10, 50), DELTA);
    }

    @Test
    void testItemDiscountMultiple() {
        CartItem[] cartItems = {
                new CartItem(20, 2),
                new CartItem(30, 2),
                new CartItem(10, 3),
        };
        assertEquals(109.0, getTotal(cartItems, 3, 70), DELTA);
    }
}