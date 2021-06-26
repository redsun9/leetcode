package leetcode.leetcode18xx.leetcode1860;

public class Solution {
    /*
        solve (a+x)*(x+1)<=s, return max integer
     */
    private static int solve(int a, int s) {
        long x = Math.round((-(a + 1.0) + Math.sqrt((a + 1.0) * (a + 1.0) + 4.0 * (s - a))) / 2);
        if ((a + x) * (x + 1) > s) x--;
        return (int) x;
    }

    public int[] memLeak(int memory1, int memory2) {
        //first find moment after which sticks will be alternating after each move
        int diff = Math.abs(memory1 - memory2);
        int max = Math.max(memory1, memory2);
        int t1 = (int) Math.round((-1 + Math.sqrt(1 + 8.0 * diff)) / 2);
        if (t1 * (t1 + 1L) / 2 < diff) t1++;

        int[] ans = new int[3];
        long s1 = t1 * (t1 + 1L) / 2;
        if (max < s1) {
            // all memory from the largest stick is allocated and other can't be used
            s1 = t1 * (t1 - 1L) / 2;
            ans[0] = t1;
            ans[1] = memory1 >= s1 ? (int) (memory1 - s1) : memory1;
            ans[2] = memory2 >= s1 ? (int) (memory2 - s1) : memory2;
        } else {
            if (memory1 >= memory2) memory1 -= s1;
            else memory2 -= s1;
            if (memory1 >= memory2) {
                // the alternating begins from the first stick
                int n1 = solve(t1 + 1, memory1); // rounds of alternating first stick can handle
                int n2 = solve(t1 + 2, memory2); // rounds of alternating second stick can handle
                ans[0] = Math.max(t1 + 1 + 2 * n1, t1 + 2 + 2 * n2) + 1;
                ans[1] = memory1 - (t1 + 1 + n1) * (n1 + 1);
                ans[2] = memory2 - (t1 + 2 + n2) * (n2 + 1);
            } else {
                // the alternating begins from the second stick
                int n1 = solve(t1 + 2, memory1); // rounds of alternating first stick can handle
                int n2 = solve(t1 + 1, memory2);// rounds of alternating second stick can handle
                ans[0] = Math.max(t1 + 2 + 2 * n1, t1 + 1 + 2 * n2) + 1;
                ans[1] = memory1 - (t1 + 2 + n1) * (n1 + 1);
                ans[2] = memory2 - (t1 + 1 + n2) * (n2 + 1);
            }
        }
        return ans;
    }
}
