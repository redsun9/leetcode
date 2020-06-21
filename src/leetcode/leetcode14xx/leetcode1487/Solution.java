package leetcode.leetcode14xx.leetcode1487;

import java.util.HashMap;

public class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] ans = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            if (map.containsKey(name)) {
                int n = map.get(name) + 1;
                String testName = name + "(" + n + ")";
                while (map.containsKey(testName)) {
                    n++;
                    testName = name + "(" + n + ")";
                }
                map.put(name, n);
                map.put(testName, 0);
                ans[i] = testName;
            } else {
                map.put(name, 0);
                ans[i] = name;
            }
        }
        return ans;
    }
}
