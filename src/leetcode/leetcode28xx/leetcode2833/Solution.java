package leetcode.leetcode28xx.leetcode2833;

public class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int a = 0, b = 0;
        for (int i = 0; i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'L' -> a--;
                case 'R' -> a++;
                default -> b++;
            }
        }
        return Math.abs(a) + b;
    }
}
