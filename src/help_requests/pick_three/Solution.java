package help_requests.pick_three;

public class Solution {
    //  если  n>3,  то f(n) = f(n/2) + f(n-n/2)
    //  если n<=3, то f(n) = 1
    public static int pickThree(int n) {
        if (n <= 1) return 1;
        int h = Integer.highestOneBit(n);
        int m = h | h >> 1;
        if (m >= n) return h >> 1;
        else return (h >> 1) + n - m;
    }
}
