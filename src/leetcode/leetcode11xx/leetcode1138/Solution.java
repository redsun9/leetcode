package leetcode.leetcode11xx.leetcode1138;

public class Solution {
    public String alphabetBoardPath(String target) {
        int n = target.length();
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int c = target.charAt(i) - 'a';
            int nextX = c / 5, nextY = c % 5;
            while (x > nextX) {
                sb.append('U');
                x--;
            }
            while (y < nextY) {
                sb.append('R');
                y++;
            }
            while (y > nextY) {
                sb.append('L');
                y--;
            }
            while (x < nextX) {
                sb.append('D');
                x++;
            }
            sb.append("!");
        }
        return sb.toString();
    }
}
