package leetcode.leetcode26xx.leetcode2610;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        int ansSize = 0;
        for (Integer value : map.values()) ansSize = Math.max(ansSize, value);
        List<List<Integer>> ans = new ArrayList<>(ansSize);
        for (int i = 0; i < ansSize; i++) ans.add(new ArrayList<>());
        for (Integer key : map.keySet()) {
            int value = map.get(key);
            for (int i = 0; i < value; i++) ans.get(i).add(key);
        }
        return ans;
    }
}
