package leetcode.leetcode0xx.leetcode18;

import java.util.*;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Solution2 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        if (n < 4) return Collections.emptyList();

        Arrays.sort(nums);
        Map<Integer, List<int[]>> map = new HashMap<>();
        Set<List<Integer>> ans = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (i > 1 && nums[i] == nums[i - 2]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j > i + 2 && nums[j] == nums[j - 2]) continue;
                List<int[]> list = map.get(target - nums[i] - nums[j]);
                if (list != null) {
                    for (int[] pair : list) {
                        int m1 = min(pair[0], i);
                        int m2 = min(pair[1], j);
                        int m3 = max(pair[0], i);
                        int m4 = max(pair[1], j);
                        if (m1 == m3 || m1 == m4 || m2 == m3 || m2 == m4) continue;
                        ans.add(List.of(nums[m1], nums[min(m2, m3)], nums[max(m2, m3)], nums[m4]));
                    }
                }
                map.computeIfAbsent(nums[i] + nums[j], key -> new ArrayList<>()).add(new int[]{i, j});
            }
        }
        return new ArrayList<>(ans);
    }
}
