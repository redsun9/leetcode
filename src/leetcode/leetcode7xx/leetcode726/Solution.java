package leetcode.leetcode7xx.leetcode726;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public String countOfAtoms(String formula) {
        Stack<Map<String, Integer>> stack = new Stack<>();
        Map<String, Integer> map = new HashMap<>();
        int i = 0, n = formula.length();
        while (i < n) {
            char c = formula.charAt(i++);
            if (c == '(') {
                stack.push(map);
                map = new HashMap<>();
            } else if (c == ')') {
                int multiplier = 0;
                while (i < n) {
                    c = formula.charAt(i);
                    if (c >= '0' && c <= '9') multiplier = multiplier * 10 + c - '0';
                    else break;
                    i++;
                }
                if (multiplier == 0) multiplier = 1;
                Map<String, Integer> tmp = map;
                map = stack.pop();
                for (Map.Entry<String, Integer> entry : tmp.entrySet()) {
                    map.put(entry.getKey(), map.getOrDefault(entry.getKey(), 0) + entry.getValue() * multiplier);
                }
            } else {
                int start = i - 1;
                while (i < n) {
                    c = formula.charAt(i);
                    if (c < 'a' || c > 'z') break;
                    i++;
                }
                String element = formula.substring(start, i);
                int multiplier = 0;
                while (i < n) {
                    c = formula.charAt(i);
                    if (c >= '0' && c <= '9') multiplier = multiplier * 10 + c - '0';
                    else break;
                    i++;
                }
                if (multiplier == 0) multiplier = 1;
                map.put(element, map.getOrDefault(element, 0) + multiplier);
            }
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        entries.sort(Map.Entry.comparingByKey());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1) sb.append(entry.getValue());
        }
        return sb.toString();
    }
}
