package help_requests.discount_price;

import java.util.Arrays;
import java.util.Comparator;

// given orders [number of the i-th good, price of single]
// each k-th item get a discount of d percents
//calculate total
public class DoubleSolution {
    public static double getTotal(CartItem[] cartItems, int k, double discount) {
        Arrays.sort(cartItems, Comparator.comparingDouble(CartItem::price));
        double total = 0;
        discount /= 100.0;
        int toSkip = k - 1;
        for (int i = cartItems.length - 1; i >= 0; i--) {
            CartItem cartItem = cartItems[i];
            int itemsToCalculateDiscount = (cartItem.amount - toSkip + k - 1) / k;
            total += cartItem.price * (cartItem.amount - discount * itemsToCalculateDiscount);
            toSkip -= cartItem.amount % k;
            if (toSkip < 0) toSkip += k;
        }
        return total;
    }

    public record CartItem(double price, int amount) {
    }
}
