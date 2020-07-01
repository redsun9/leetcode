package raiffeisen.day3;

public class StringCompressor {
    public static String compress(String s) {
        if (s == null) return null;
        int n = s.length();
        if (n <= 1) return s;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < n) {
            int start = i++;
            char c = s.charAt(start);
            while (i < n && s.charAt(i) == c) i++;
            if (i - start == 1) sb.append(c);
            else sb.append(i - start).append(c);
        }
        return sb.toString();
    }
}
