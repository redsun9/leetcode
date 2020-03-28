package leetcode.leetcode470;

public class Solution extends SolBase {
    public int rand10() {
        int ans = 49;
        while (ans > 39) {
            ans = rand7() * 7 + rand7() - 8;
        }
        return ans % 10 + 1;
    }
}
