package binsearch.binsearch8;

public class Solution {
    public int solve(String message) {
        int n = message.length();
        char prevCh = '0', c;
        int p1 = 0, p2 = 1, p3;
        for (int i = 0; i < n; i++) {
            c = message.charAt(i);
            p3 = 0;
            if (c != '0') p3 += p2;
            if (prevCh == '1' || prevCh == '2' && c <= '6') p3 += p1;
            p1 = p2;
            p2 = p3;
            prevCh = c;
        }
        return p2;
    }
}
