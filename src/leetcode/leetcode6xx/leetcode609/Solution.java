package leetcode.leetcode6xx.leetcode609;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] splits = path.split(" ");
            String dir = splits[0];
            int n = splits.length;
            for (int i = 1; i < n; i++) {
                String split = splits[i];
                int pos = split.indexOf('(');
                map.computeIfAbsent(
                        split.substring(pos + 1, split.length() - 1),
                        k -> new ArrayList<>()
                ).add(dir + '/' + split.substring(0, pos));
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> value : map.values()) if (value.size() > 1) ans.add(value);
        return ans;
    }
}
