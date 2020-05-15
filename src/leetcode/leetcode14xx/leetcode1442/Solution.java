package leetcode.leetcode14xx.leetcode1442;

import java.util.HashMap;

public class Solution {
    public int countTriplets(int[] arr) {
        int ans = 0;
        HashMap<Integer, Pair> map = new HashMap<>();
        map.put(0, new Pair(-1, 1));
        int tmp = 0;
        for (int i = 0, n = arr.length; i < n; i++) {
            tmp ^= arr[i];
            if (map.containsKey(tmp)) {
                Pair pair = map.get(tmp);
                ans += i * pair.number - pair.number - pair.sum;
                map.put(tmp, pair.add(i));
            } else map.put(tmp, new Pair(i, 1));
        }
        return ans;
    }

    private static class Pair {
        private final int sum, number;

        public Pair(int sum, int number) {
            this.sum = sum;
            this.number = number;
        }

        public Pair add(int i) {
            return new Pair(sum + i, number + 1);
        }
    }
}
