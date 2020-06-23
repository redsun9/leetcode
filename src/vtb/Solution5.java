package vtb;

import java.util.HashMap;

/*
    Длина наибольшей подстроки без повторяющихся символов
 */
public class Solution5 {
    public static int getLongest(String s) {
        // Напишите ваш код здесь...
        int n = s.length();
        if (n < 2) return n;
        HashMap<Character, Integer> lastPos = new HashMap<>();
        int ans = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (!lastPos.containsKey(c)) {
                ans = Math.max(ans, i - start + 1);
            } else {
                start = lastPos.get(c) + 1;
            }
            lastPos.put(c, i);
        }
        return ans;
    }
}
