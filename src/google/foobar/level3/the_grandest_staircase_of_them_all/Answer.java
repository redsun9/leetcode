package google.foobar.level3.the_grandest_staircase_of_them_all;

//we use generating function
// Prod_{i=1}^{+inf} (1+x^i)
public class Answer {
    public static int answer(int n) {
        if (n <= 2) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int k = 1, sum = 0; k < n; k++) {
            sum += k;
            for (int i2 = Math.min(sum, n), i1 = i2 - k; i1 >= 0; i2--, i1--) dp[i2] += dp[i1];
        }
        return dp[n];
    }
}
