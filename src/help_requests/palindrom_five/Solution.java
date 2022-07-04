package help_requests.palindrom_five;

//дана бинарная строка, найти количество всех подпоследовательностей длины 5 являющихся палиндромами.
// Ответ вывести по модулю 10^9+7, size(s) <= 10^5.
public class Solution {
    private static final int p = 1_000_000_007;

    public int getNumberOfPalindromesOfLengthFive(String s) {
        int[] cnt1 = new int[2];
        int[] cnt2 = new int[4];
        int[] cnt3 = new int[8];
        int[] cnt4 = new int[8];
        int[] cnt5 = new int[8];
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - '0';
            for (int j = 0; j < 4; j++) {
                int k = c << 2 | j;
                cnt5[k] += cnt4[k];
                if (cnt5[k] >= p) cnt5[k] -= p;
            }
            for (int j = 0; j < 4; j++) {
                int k = c << 1 | ((j & 2) << 1) | (j & 1);
                cnt4[k] += cnt3[k];
                if (cnt4[k] >= p) cnt4[k] -= p;
            }
            for (int j = 0; j < 4; j++) {
                int k = j * 2 + c;
                cnt3[k] += cnt2[j];
                if (cnt3[k] >= p) cnt3[k] -= p;
            }
            for (int j = 0; j < 2; j++) {
                int k = j * 2 + c;
                cnt2[k] += cnt1[j];
                if (cnt2[k] >= p) cnt2[k] -= p;
            }
            cnt1[c] += 1;
            if (cnt1[c] == p) cnt1[c] = 0;
        }
        int ans = 0;
        for (int cnt : cnt5) {
            ans += cnt;
            if (ans >= p) ans -= p;
        }
        return ans;
    }
}
