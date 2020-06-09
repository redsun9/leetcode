package leetcode.leetcode0xx.leetcode71;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {
        String[] parts = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String part : parts) {
            switch (part) {
                case "..":
                    if (!stack.isEmpty()) stack.pollLast();
                    break;
                case "":
                case ".":
                    break;
                default:
                    stack.addLast(part);
                    break;
            }
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append('/').append(stack.pollFirst());
        }
        return sb.toString();
    }
}
