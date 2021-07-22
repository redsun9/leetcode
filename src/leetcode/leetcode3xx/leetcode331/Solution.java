package leetcode.leetcode3xx.leetcode331;

public class Solution {
    public boolean isValidSerialization(String preorder) {
        int n = preorder.length();
        int counter = 1;
        for (int i = 0; i <= n; i++) {
            if (i == n || preorder.charAt(i) == ',') {
                if (preorder.charAt(i - 1) == '#') {
                    counter--;
                    if (counter < 0 || counter == 0 && i != n) return false;
                } else counter++;
            }
        }
        return counter == 0;
    }
}
