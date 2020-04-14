package leetcode.challenge_2020.april14th;

public class Solution {
    public String stringShift(String s, int[][] shifts) {
        int length = s.length();
        if (length <= 1) return s;
        int totalShift = 0;
        for (int[] shift : shifts) {
            totalShift += (shift[0] * 2 - 1) * shift[1];
        }
        if (totalShift % length == 0) return s;
        if (totalShift > 0) {
            totalShift %= length;
            return s.substring(length - totalShift) + s.substring(0, length - totalShift);
        } else {
            totalShift = -totalShift;
            totalShift %= length;
            return s.substring(totalShift) + s.substring(0, totalShift);
        }
    }
}
