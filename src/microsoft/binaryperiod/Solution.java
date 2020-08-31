package microsoft.binaryperiod;

public class Solution {
    public int solution(int n) {
        int[] d = new int[30];
        int l = 0;
        while (n > 0) {
            d[l] = n % 2;
            l++;
            n /= 2;
        }
        for (int p = 1; p <= l / 2; p++) {
            boolean ok = true;
            for (int i = 0; i < l - p; i++) {
                if (d[i] != d[i + p]) {
                    ok = false;
                    break;
                }
            }
            if (ok) return p;
        }
        return -1;
    }
}
