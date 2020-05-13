package leetcode.leetcode4xx.leetcode402;

import java.util.ArrayDeque;

public class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (n == k) return "0";

        ArrayDeque<Character> stack = new ArrayDeque<>(n - k);
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > c) {
                stack.pollLast();
                k--; // мы больше не рассматриваем эту цифру
            }
            stack.addLast(c);
        }
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        boolean nonNullMet = false;
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Character character = stack.pollFirst();
            if (character != '0') {
                sb.append(character);
                nonNullMet = true;
            } else if (nonNullMet) {
                sb.append(character);
            }
        }
        if (sb.length() == 0) return "0";
        else return sb.toString();
    }
}
