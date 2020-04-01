package leetcode.leetcode3xx.leetcode374;

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while (lo != hi) {
            int mid = lo + (hi - lo) / 2;
            int guess = guess(mid);
            if (guess == 0) return mid;
            else if (guess > 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}
