package help_requests.discount_price;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Comparator;

import static java.math.BigDecimal.ZERO;
import static java.math.BigDecimal.valueOf;
import static java.math.RoundingMode.UNNECESSARY;

// given orders [number of the i-th good, price of single]
// each k-th item get a discount of d percents
//calculate total
public class BigDecimalSolution {
    public static BigDecimal getTotal(CartItem[] cartItems, int k, BigDecimal discount) {
        Arrays.sort(cartItems, Comparator.comparing(CartItem::price));
        BigDecimal total = ZERO;
        discount = discount.divide(valueOf(100), UNNECESSARY);
        int toSkip = k - 1;
        for (int i = cartItems.length - 1; i >= 0; i--) {
            CartItem cartItem = cartItems[i];
            int itemsToCalculateDiscount = (cartItem.amount - toSkip + k - 1) / k;
            BigDecimal discountAmount = discount.multiply(valueOf(itemsToCalculateDiscount));
            BigDecimal afterDiscountAmount = valueOf(cartItem.amount).subtract(discountAmount);
            total = total.add(cartItem.price.multiply(afterDiscountAmount));
            toSkip -= cartItem.amount % k;
            if (toSkip < 0) toSkip += k;
        }
        return total;
    }

    public record CartItem(BigDecimal price, int amount) {
    }
}
