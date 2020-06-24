package vtb;

public class Solution9 {
    public static boolean hasSubpattern(String s) {
        int n = s.length();
        if (n < 2) return false;
        int tmp = n;
        if (tmp % 2 == 0) {
            if (s.substring(0, n / 2).equals(s.substring(n / 2))) return true;
            while (tmp % 2 == 0) tmp /= 2;
        }
        for (int i = 3; i * i <= tmp; i += 2) {
            if (tmp % i != 0) continue;
            if (check(s, i, n)) return true;
            while (tmp % i == 0) tmp /= i;
        }
        return tmp != 1 && tmp < n && check(s, tmp, n);
    }

    private static boolean check(String s, int k, int n) {
        int t = n / k;
        String str = s.substring(0, t);
        for (int j = 1; j < k; j++) {
            if (!s.substring(j * t, j * t + t).equals(str)) return false;
        }
        return true;
    }
}
