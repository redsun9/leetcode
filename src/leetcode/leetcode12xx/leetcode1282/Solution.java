package leetcode.leetcode12xx.leetcode1282;

import java.util.*;

public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        int n = groupSizes.length;
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int groupSize = groupSizes[i];
            if (groupSize == 1) ans.add(Collections.singletonList(i));
            else {
                List<Integer> list = map.get(groupSize);
                if (list == null) {
                    list = new ArrayList<>(groupSize);
                    list.add(i);
                    map.put(groupSize, list);
                } else {
                    list.add(i);
                    if (list.size() == groupSize) {
                        map.remove(groupSize);
                        ans.add(list);
                    }
                }
            }
        }
        return ans;
    }
}
