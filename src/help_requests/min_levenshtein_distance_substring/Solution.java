package help_requests.min_levenshtein_distance_substring;

// Дано S и T. Найти в T подстроку, из которой можно получить S минимальным количеством вставок символов в начало или конец,
// замен одного символа.
public class Solution {
    public static String solve(String t, String s) {
        int min = s.length();
        int resStart = 0, resEnd = 0;
        int m = t.length(), n = s.length();
        for (int shift = -n; shift <= m; shift++) {
            int cur = Math.max(0, -shift) + Math.max(0, shift + n - m);
            for (int i = Math.max(0, shift), j = Math.max(0, -shift); i < m && j < n; i++, j++) {
                if (t.charAt(i) != s.charAt(j)) cur++;
            }
            if (cur < min) {
                min = cur;
                resStart = Math.max(0, shift);
                resEnd = Math.min(m, shift + n);
            }
        }
        return t.substring(resStart, resEnd);
    }
}
