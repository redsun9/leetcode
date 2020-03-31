package leetcode.leetcode38;

import java.util.LinkedList;

public class Solution {
    public String countAndSay(int n) {
        LinkedList<Character> previous = new LinkedList<>();
        previous.add('1');
        for (int i = 2; i <= n; i++) {
            LinkedList<Character> current = new LinkedList<>();
            char prev = previous.getFirst();
            int start = 0;
            int j = 0;
            for (Character character : previous) {
                if (character != prev) {
                    for (char aChar : Integer.toString(j - start).toCharArray()) {
                        current.addLast(aChar);
                    }
                    current.addLast(prev);
                    start = j;
                    prev = character;
                }
                j++;
            }
            for (char aChar : Integer.toString(previous.size() - start).toCharArray()) {
                current.addLast(aChar);
            }
            current.addLast(prev);
            previous = current;
        }
        StringBuilder sb = new StringBuilder(previous.size());
        for (Character character : previous) {
            sb.append(character);
        }
        return sb.toString();
    }
}
