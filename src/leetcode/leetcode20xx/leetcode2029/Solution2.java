package leetcode.leetcode20xx.leetcode2029;

@SuppressWarnings("DuplicatedCode")
public class Solution2 {
    public boolean stoneGameIX(int[] stones) {
        int a = 0, b = 0, c = 0;
        for (int stone : stones) {
            switch (stone % 3) {
                case 0 -> a++;
                case 1 -> b++;
                case 2 -> c++;
            }
        }
        return solve(a, b, c);

    }

    static boolean solve(int a, int b, int c) {
        if (a % 2 == 0 && (b == 0 || c == 0)) return false;
        return a % 2 != 1 || Math.abs(b - c) >= 3;
    }
}
