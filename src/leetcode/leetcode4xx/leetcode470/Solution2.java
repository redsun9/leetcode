package leetcode.leetcode4xx.leetcode470;

public class Solution2 extends SolBase {
    public int rand10() {
        int a;
        while (true) {
            a = rand7() * 7 + rand7() - 8;
            if (a <= 39) return a % 10 + 1;
            a = (a - 40) * 7 + rand7() - 1;
            if (a <= 59) return a % 10 + 1;
            a = (a - 60) * 7 + rand7() - 1;
            if (a <= 19) return a % 10 + 1;
        }
    }
}
