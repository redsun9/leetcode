package leetcode.leetcode20xx.leetcode2062;

@SuppressWarnings("PointlessArithmeticExpression")
public class Solution {
    public int countVowelSubstrings(String word) {
        int[] count = new int[26];
        int n = word.length(), ans = 0;
        int diffVowels = 0, leftBorder = 0, rightBorder = 0;


        for (int i = 0; i < n; i++) {
            switch (word.charAt(i)) {
                case 'a', 'e', 'i', 'u', 'o' -> {
                    if (count[word.charAt(i) - 'a']++ == 0) diffVowels++;
                    while (diffVowels == 5) if (--count[word.charAt(rightBorder++) - 'a'] == 0) diffVowels--;
                    ans += rightBorder - leftBorder;
                }
                default -> {
                    count['a' - 'a'] = count['e' - 'a'] = count['i' - 'a'] = count['u' - 'a'] = count['o' - 'a'] = 0;
                    leftBorder = rightBorder = i + 1;
                    diffVowels = 0;
                }
            }
        }
        return ans;
    }
}
