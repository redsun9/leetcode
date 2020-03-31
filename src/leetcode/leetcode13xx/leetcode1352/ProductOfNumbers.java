package leetcode.leetcode13xx.leetcode1352;

import java.util.HashMap;

public class ProductOfNumbers {
    HashMap<Integer, Integer> product = new HashMap<>();

    public ProductOfNumbers() {
    }

    public void add(int num) {
        if (num == 0) {
            product.clear();
        } else if (!product.isEmpty()) {
            int size = product.size();
            product.put(size + 1, num * product.get(size));
        } else {
            product.put(1, num);
        }
    }

    public int getProduct(int k) {
        int size = product.size();
        if (size >= k) {
            int ans = product.get(size);
            if (size > k) ans /= product.get(size - k);
            return ans;
        } else return 0;
    }
}
