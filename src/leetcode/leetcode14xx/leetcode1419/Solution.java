package leetcode.leetcode14xx.leetcode1419;

public class Solution {
    public int minNumberOfFrogs(String croakOfFrogs) {
        if (croakOfFrogs.length() % 5 != 0) return -1;
        int[] count = new int[4];
        int maxFrog = 0;
        for (char c : croakOfFrogs.toCharArray()) {
            switch (c) {
                case 'c':
                    count[0]++;
                    maxFrog = Math.max(maxFrog, count[0]);
                    break;
                case 'r':
                    count[1]++;
                    if (count[1] > count[0]) return -1;
                    break;
                case 'o':
                    count[2]++;
                    if (count[2] > count[1]) return -1;
                    break;
                case 'a':
                    count[3]++;
                    if (count[3] > count[2]) return -1;
                    break;
                case 'k':
                    if (count[3] <= 0) return -1;
                    count[3]--;
                    count[2]--;
                    count[1]--;
                    count[0]--;
                    break;
                default:
                    return -1;
            }
        }
        if (count[0] == 0) return maxFrog;
        else return -1;
    }
}
