package help_requests.pick_three2;

public class Solution {
    //  если  n>3, то f(n) = f(n/2) + f(n-n/2)
    //  если n==3, то f(n) = 1
    //  если n<=2, то f(n) = 0
    public static int pickThree(int n) {
        if (n <= 2) return 0;
        int h = Integer.highestOneBit(n);
        return (h >> 1) - Math.abs((h | h >> 1) - n);
    }
}
