package vtb;

import java.util.ArrayDeque;

/*
remove repeated k times
 */
public class Solution15 {
    public static String removeDuplicates(String s, int k) {
        // Напишите ваш код здесь...
        int n = s.length();
        if (n < k) return s;
        ArrayDeque<Character> sc = new ArrayDeque<>();
        ArrayDeque<Integer> si = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!sc.isEmpty() && sc.peekLast() == c) {
                sc.pollLast();
                int count = si.pollLast() + 1;
                if (count != k) {
                    sc.addLast(c);
                    si.addLast(count);
                }
            } else {
                sc.addLast(c);
                si.addLast(1);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!sc.isEmpty()) {
            Character character = sc.pollFirst();
            Integer count = si.pollFirst();
            for (int i = 0; i < count; i++) {
                sb.append(character);
            }
        }
        return sb.toString();
    }
}
