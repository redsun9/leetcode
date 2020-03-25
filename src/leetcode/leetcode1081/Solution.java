package leetcode.leetcode1081;

import java.util.LinkedList;

public class Solution {
    public String smallestSubsequence(String text) {
        char[] chars = text.toCharArray();
        int[] charCount = new int[26];
        LinkedList<Integer> stack = new LinkedList<>();
        boolean[] seen = new boolean[26];
        for (char c : chars) {
            charCount[c - 'a']++;
        }
        for (char c : chars) {
            int a = c - 'a';
            charCount[a]--;
            if (seen[a]) continue;
            while (!stack.isEmpty() && charCount[stack.peekLast()] > 0 && a < stack.peekLast())
                seen[stack.pollLast()] = false;
            stack.addLast(a);
            seen[a] = true;
        }
        int size = stack.size();
        char[] ans = new char[size];
        for (int i = 0; i < size; i++) {
            ans[i] = (char) ('a' + stack.pollFirst());
        }
        return new String(ans);
    }
}
