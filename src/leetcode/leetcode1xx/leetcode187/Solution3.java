package leetcode.leetcode1xx.leetcode187;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution3 implements RepeatedDnaSequenceFinder {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> count = new HashMap<>();
        for (int i = 10; i <= s.length(); i++) {
            count.merge(s.substring(i - 10, i), 1, Integer::sum);
        }
        LinkedList<String> ans = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            if (entry.getValue() > 1) ans.add(entry.getKey());
        }
        return ans;
    }
}
