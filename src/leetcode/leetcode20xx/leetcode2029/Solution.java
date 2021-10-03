package leetcode.leetcode20xx.leetcode2029;

@SuppressWarnings("DuplicatedCode")
public class Solution {
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

    @SuppressWarnings("RedundantIfStatement")
    static boolean solve(int a, int b, int c) {
        a &= 1;
        if (b == 0 && c == 0) return false;
        if (b == 0 && c <= 2) return false;
        if (c == 0 && b <= 2) return false;
        if (b == 0) return a == 1;
        if (c == 0) return a == 1;

        if (a == 0 && b == 1 && c > 0) return true;
        if (a == 0 && c == 1 && b > 0) return true;
        if (a == 0 && b >= 2 && c + 1 > b) return true;
        if (a == 0 && c >= 2 && b + 1 > c) return true;

        if (a == 1 && b >= 3 && c + 2 < b) return true;
        if (a == 1 && c >= 3 && b + 2 < c) return true;
        return false;
    }
}
