package leetcode.leetcode3xx.leetcode398;

import java.util.*;

public class Solution {
    private final Random random;
    private final Map<Integer, List<Integer>> map;

    public Solution(int[] nums) {
        this.map = new HashMap<>();
        this.random = new Random();
        for (int i = 0, n = nums.length; i < n; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>(1));
            list.add(i);
            map.put(nums[i], list);
        }
    }

    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(random.nextInt(list.size()));
    }
}
