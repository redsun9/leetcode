package leetcode.leetcode8xx.leetcode811;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String cpdomain : cpdomains) {
            int i = cpdomain.indexOf(' ');
            int n = Integer.parseInt(cpdomain, 0, i, 10);
            String s = cpdomain.substring(i + 1);
            count.compute(s, (k, v) -> v == null ? n : v + n);
            i = s.indexOf('.');
            while (i != -1) {
                count.compute(s.substring(i + 1), (k, v) -> v == null ? n : v + n);
                i = s.indexOf('.', i + 1);
            }
        }
        List<String> ans = new ArrayList<>(count.size());
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            ans.add(entry.getValue() + " " + entry.getKey());
        }
        return ans;
    }
}
