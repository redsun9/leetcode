package leetcode.leetcode5xx.leetcode575;

import java.util.HashMap;

public class Solution {
    public int distributeCandies(int[] candies) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int candy : candies) {
            counts.put(candy, counts.getOrDefault(candy, 0) + 1);
        }
        return Math.min(candies.length / 2, counts.size());
    }
}
