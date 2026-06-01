package leetcode.leetcode34xx.leetcode3463;

public class Solution {
    public boolean hasSameDigits(String s) {
        int n = s.length();
        Mod10[] facts = new Mod10[n + 1];
        facts[0] = Mod10.fromNumber(1);
        for (int i = 1; i <= n; i++) facts[i] = facts[i - 1].mul(Mod10.fromNumber(i));

        int digit1 = 0, digit2 = 0;
        for (int i = 0; i <= n - 2; i++) {
            int coef = facts[n - 2].div(facts[i]).div(facts[n - 2 - i]).toInteger();
            digit1 += (s.charAt(i) - '0') * coef;
            digit2 += (s.charAt(i + 1) - '0') * coef;
        }
        return digit1 % 10 == digit2 % 10;
    }

    private record Mod10(int power2, int power5, int mod10) {
        private static final int[] inv;
        private static final int[] mod2 = {2, 4, 8, 6};
        private static final int[] mod5 = {5};

        static {
            inv = new int[10];
            inv[1] = 1;
            inv[3] = 7;
            inv[7] = 3;
            inv[9] = 9;
        }

        Mod10 mul(Mod10 b) {
            return new Mod10(power2 + b.power2, power5 + b.power5, (mod10 * b.mod10) % 10);
        }

        Mod10 div(Mod10 b) {
            return new Mod10(power2 - b.power2, power5 - b.power5, (mod10 * inv[b.mod10]) % 10);
        }

        static Mod10 fromNumber(int n) {
            int power2 = 0, power5 = 0;
            while (n % 2 == 0) {
                power2++;
                n /= 2;
            }
            while (n % 5 == 0) {
                power5++;
                n /= 5;
            }
            return new Mod10(power2, power5, n);
        }

        int toInteger() {
            int ans = mod10;
            if (power2 != 0) ans = ans * mod2[(power2 - 1) % mod2.length] % 10;
            if (power5 != 0) ans = ans * mod5[(power5 - 1) % mod5.length] % 10;
            return ans;
        }
    }
}
