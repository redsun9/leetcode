package leetcode.leetcode3xx.leetcode320;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    /**
     * @param word: the given word
     * @return the generalized abbreviations of a word
     */
    public List<String> generateAbbreviations(String word) {
        int n = word.length();
        List<String> ans = new ArrayList<>(1 << n);
        char[] tmp = new char[n];

        for (int key = 0; key < 1 << n; key++) {
            int pos = 0, left = 0, right = 0;
            while (right <= n) {
                if (right == n || (key >>> right & 1) == 0) {
                    if (left != right) {
                        int k = right - left;
                        int d = 0;
                        while (k != 0) {
                            tmp[pos++] = (char) ('0' + k % 10);
                            d++;
                            k /= 10;
                        }
                        if (d != 1) {
                            for (int i = pos - d, j = pos - 1; i < j; i++, j--) {
                                char t = tmp[i];
                                tmp[i] = tmp[j];
                                tmp[j] = t;
                            }
                        }
                    }
                    if (right != n) tmp[pos++] = word.charAt(right);
                    left = right + 1;
                }
                right++;
            }
            ans.add(new String(tmp, 0, pos));
        }
        return ans;
    }
}
