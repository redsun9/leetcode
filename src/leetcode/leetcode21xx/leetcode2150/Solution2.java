package leetcode.leetcode21xx.leetcode2150;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public List<Integer> findLonely(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.compute(num, (k, v) -> v == null ? 1 : v + 1);
        List<Integer> ans = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            if (entry.getValue() == 1 && !map.containsKey(key - 1) && !map.containsKey(key + 1)) ans.add(key);
        }
        return ans;
    }
}
