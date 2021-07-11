package leetcode.leetcode13xx.leetcode1390;

public class Solution {
    private static final int[] firstPrimes = {
            2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97,
            101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
            211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293,
            307, 311, 313
    };

    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int numOfDivisors = 1;
            int sumOfDivisors = 1;

            for (int p : firstPrimes) {
                if (p * p > num) break;
                if (num % p == 0) {
                    int a = 0;
                    int pa = p;
                    while (num % p == 0) {
                        num /= p;
                        a++;
                        pa *= p;
                    }
                    numOfDivisors *= (a + 1);
                    sumOfDivisors = sumOfDivisors * (pa - 1) / (p - 1);
                    if (numOfDivisors == 3 || numOfDivisors > 4) break;
                }
            }
            if (numOfDivisors == 4 && num == 1) ans += sumOfDivisors;
            else if (numOfDivisors == 2 && num != 1) {
                ans += sumOfDivisors * (1 + num);
            }
        }
        return ans;
    }
}
