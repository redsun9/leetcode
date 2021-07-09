package leetcode.leetcode4xx.leetcode480;

import java.util.Comparator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;

public class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = Comparator.comparingInt((Integer x) -> nums[x]).thenComparingInt(x -> x);
        TreeSet<Integer> left = new TreeSet<>(comparator.reversed());
        TreeSet<Integer> right = new TreeSet<>(comparator);
        DoubleSupplier median = k % 2 == 0 ?
                () -> ((double) nums[left.first()] + nums[right.first()]) / 2.0 :
                () -> (double) nums[right.first()];
        Runnable balance = () -> {
            while (left.size() > right.size()) right.add(left.pollFirst());
        };
        Consumer<Integer> remove = x -> {
            if (!left.remove(x)) right.remove(x);
        };

        int n = nums.length;
        double[] ans = new double[n - k + 1];
        for (int i = 0; i < k; i++) left.add(i);
        balance.run();
        ans[0] = median.getAsDouble();
        for (int i1 = 0, i2 = k, pos = 1; i2 < n; i1++, i2++, pos++) {
            remove.accept(i1);
            right.add(i2);
            left.add(right.pollFirst());
            balance.run();
            ans[pos] = median.getAsDouble();
        }
        return ans;
    }
}
