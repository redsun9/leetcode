package leetcode.leetcode16xx.leetcode1655;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    private static boolean canDistribute(
            SegmentTree tree, int[] quantity, int m, int customerMask
    ) {
        if (customerMask == 0) return true;
        int minimumBit = Integer.lowestOneBit(customerMask);
        customerMask ^= minimumBit;

        //iterate through all submasks
        int subMask = customerMask;
        while (true) {
            int total = 0;
            int tmpMask = subMask | minimumBit;

            //find required sum
            for (int i = 0; i < m; i++) {
                if ((tmpMask & (1 << i)) != 0) {
                    total += quantity[i];
                }
            }
            int lowestIdx = tree.findLowestIdx(total);
            if (lowestIdx >= 0) {
                tree.acquireIdx(lowestIdx);
                if (canDistribute(tree, quantity, m, customerMask ^ subMask)) return true;
                tree.releaseIdx(lowestIdx);
            }
            if (subMask == 0) return false;
            subMask = (subMask - 1) & customerMask;
        }
    }

    private static int nextPow2(int n) {
        if ((n & (n - 1)) == 0) return n;
        else return Integer.highestOneBit(n) << 1;
    }

    public boolean canDistribute(int[] nums, int[] quantity) {
        if (nums.length == 0) return quantity.length == 0;
        List<Integer> list = Arrays.stream(nums).boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .map(Long::intValue)
                .sorted()
                .collect(Collectors.toList());

        SegmentTree tree = new SegmentTree(list);
        return canDistribute(tree, quantity, quantity.length, (1 << quantity.length) - 1);
    }

    private static class SegmentTree {
        private final int[] a;
        private final int[] max;
        private final int n;

        SegmentTree(List<Integer> values) {
            this.n = nextPow2(values.size());
            this.a = new int[n];
            this.max = new int[n * 2 - 1];

            for (int i = 0; i < values.size(); i++) {
                a[i] = values.get(i);
                max[i + n - 1] = values.get(i);
            }

            for (int i = n - 2, i1 = 2 * i + 1, i2 = 2 * i + 2; i >= 0; i--, i1 -= 2, i2 -= 2) {
                max[i] = Math.max(max[i1], max[i2]);
            }
        }

        int findLowestIdx(int val) {
            if (max[0] < val) return -1;
            int v = 0;
            while (v < n - 1) {
                if (max[v * 2 + 1] >= val) {
                    v = v * 2 + 1;
                } else {
                    v = v * 2 + 2;
                }
            }
            return v - n + 1;
        }

        void acquireIdx(int idx) {
            int v = idx + n - 1;
            max[v] = 0;
            while (v != 0) {
                v = (v - 1) >> 1;
                max[v] = Math.max(max[(v << 1) + 1], max[(v << 1) + 2]);
            }
        }

        void releaseIdx(int idx) {
            int v = idx + n - 1;
            max[v] = a[idx];
            while (v != 0) {
                v = (v - 1) >> 1;
                max[v] = Math.max(max[(v << 1) + 1], max[(v << 1) + 2]);
            }
        }
    }
}
