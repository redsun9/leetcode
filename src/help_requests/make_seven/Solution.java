package help_requests.make_seven;

// 1/2/3/4/5/6/7/8/9/10=7
// place braces to make it true equation

public class Solution {
    public static void main(String[] args) {
        int n = 10, totalVariants = 1 << (n - 2);
        for (int mask = 0; mask < totalVariants; mask++) {
            int a = 1, b = 14;
            for (int i = 3, shift = 0; i <= n; i++, shift++) {
                if ((mask >>> shift & 1) == 1) b *= i;
                else a *= i;
            }
            if (a == b) {
                StringBuilder sb = new StringBuilder("1/");
                int maskSame = (mask ^ (mask << 1 | 1)) & (totalVariants - 1);
                for (int i = 2, shift = 0; i < n; i++, shift++) {
                    if ((maskSame >>> shift & 1) == 1) sb.append('(');
                    sb.append(i).append('/');
                }
                sb.append(n).append(")".repeat(Integer.bitCount(maskSame)));
                System.out.println(sb);
            }
        }
    }
}
