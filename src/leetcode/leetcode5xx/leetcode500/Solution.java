package leetcode.leetcode5xx.leetcode500;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    private static final HashMap<Character, Integer> map;

    static {
        map = new HashMap<>();
        map.put('q', 0);
        map.put('w', 0);
        map.put('e', 0);
        map.put('r', 0);
        map.put('t', 0);
        map.put('y', 0);
        map.put('u', 0);
        map.put('i', 0);
        map.put('o', 0);
        map.put('p', 0);

        map.put('a', 1);
        map.put('s', 1);
        map.put('d', 1);
        map.put('f', 1);
        map.put('g', 1);
        map.put('h', 1);
        map.put('j', 1);
        map.put('k', 1);
        map.put('l', 1);

        map.put('z', 2);
        map.put('x', 2);
        map.put('c', 2);
        map.put('v', 2);
        map.put('b', 2);
        map.put('n', 2);
        map.put('m', 2);


    }

    public String[] findWords(String[] words) {
        String[] ans = new String[words.length];
        int counter = 0;
        for (String word : words) {
            int row = map.get(Character.toLowerCase(word.charAt(0)));
            boolean ok = true;
            for (char c : word.toCharArray()) {
                if (map.get(Character.toLowerCase(c)) != row) {
                    ok = false;
                    break;
                }
            }
            if (ok) ans[counter++] = word;
        }
        return Arrays.copyOfRange(ans, 0, counter);
    }
}
