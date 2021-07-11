package leetcode.leetcode18xx.leetcode1807;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> map = new HashMap<>();
        for (List<String> pair : knowledge) map.put(pair.get(0), pair.get(1));
        StringBuilder sb = new StringBuilder();
        int i = 0, n = s.length();
        while (true) {
            int j = s.indexOf('(', i);
            if (j < 0) {
                sb.append(s, i, n);
                return sb.toString();
            } else {
                sb.append(s, i, j);
                int k = s.indexOf(')', j + 1);
                sb.append(map.getOrDefault(s.substring(j + 1, k), "?"));
                i = k + 1;
            }
        }
    }
}
