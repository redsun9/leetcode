package leetcode.leetcode13xx.leetcode1357;

import java.util.HashMap;

public class Cashier {
    private final HashMap<Integer, Integer> prices;
    private final double coeff;
    private final int n;
    private int counter = 0;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.coeff = (100 - discount) / 100d;
        this.prices = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            this.prices.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        counter++;
        long bill = 0;
        for (int i = 0; i < product.length; i++) {
            bill += prices.get(product[i]) * amount[i];
        }
        if (counter % n == 0) {
            return coeff * bill;
        } else {
            return bill;
        }
    }
}
