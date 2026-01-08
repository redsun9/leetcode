package leetcode.leetcode36xx.leetcode3690;

import java.util.*;

public class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        Set<ArrayWrapper> visited = new HashSet<>();

        Queue<ArrayWrapper> prev = new ArrayDeque<>(), next = new ArrayDeque<>();
        prev.add(new ArrayWrapper(nums1));

        ArrayWrapper target = new ArrayWrapper(nums2);

        int dist = 0, n = nums1.length;
        while (true) {
            while (!prev.isEmpty()) {
                ArrayWrapper poll = prev.poll();
                if (poll.equals(target)) return dist;

                for (int fromStart = 0; fromStart < n; fromStart++) {
                    for (int fromEnd = fromStart + 1; fromEnd < n; fromEnd++) {
                        for (int toStart = 0; toStart <= n; toStart++) {
                            if (toStart >= fromStart && toStart <= fromEnd) continue;
                            ArrayWrapper newNode = new ArrayWrapper(mutate(poll.arr, fromStart, fromEnd, toStart));
                            if (visited.add(newNode)) next.add(newNode);
                        }
                    }
                }
            }
            Queue<ArrayWrapper> tmp = prev;
            prev = next;
            next = tmp;
            dist++;
        }
    }

    private record ArrayWrapper(int[] arr) {
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) return false;
            ArrayWrapper other = (ArrayWrapper) obj;
            return Arrays.equals(arr, other.arr);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(arr);
        }
    }

    private static int[] mutate(int[] arr, int fromStart, int fromEnd, int toStart) {
        int[] ans = Arrays.copyOf(arr, arr.length);
        int a = Math.min(fromStart, toStart), c = Math.max(fromEnd, toStart), b = fromStart + fromEnd + toStart - a - c;
        mirror(ans, a, b - 1);
        mirror(ans, b, c - 1);
        mirror(ans, a, c - 1);
        return ans;
    }

    private static void mirror(int[] arr, int l, int r) {
        while (l < r) {
            int tmp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = tmp;
        }
    }
}
