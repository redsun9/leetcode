package leetcode.leetcode8xx.leetcode824;

public class Solution {
    public String toGoatLatin(String s) {
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int n = s.length();
        int count = 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ') {
                if (i != start) {
                    char c = s.charAt(start);
                    if (
                            c == 'a' || c == 'A' ||
                                    c == 'e' || c == 'E' ||
                                    c == 'i' || c == 'I' ||
                                    c == 'o' || c == 'O' ||
                                    c == 'u' || c == 'U'
                    ) {
                        sb.append(s, start, i);
                    } else {
                        sb.append(s, start + 1, i);
                        sb.append(s.charAt(start));
                    }
                    sb.append("ma");
                    for (int j = 0; j < count; j++) sb.append('a');
                    sb.append(' ');
                    count++;
                }
                start = i + 1;
            }
        }
        if (n != start) {
            char c = s.charAt(start);
            if (
                    c == 'a' || c == 'A' ||
                            c == 'e' || c == 'E' ||
                            c == 'i' || c == 'I' ||
                            c == 'o' || c == 'O' ||
                            c == 'u' || c == 'U'
            ) {
                sb.append(s, start, n);
            } else {
                sb.append(s, start + 1, n);
                sb.append(s.charAt(start));
            }
            sb.append("ma");
            for (int j = 0; j < count; j++) sb.append('a');
            sb.append(' ');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
