package leetcode.leetcode20xx.leetcode2063;

public class Solution {
    public long countVowels(String word) {
        int n = word.length();
        long ans = 0, left = 1, right = n;
        for (int i = 0; i < n; i++, left++, right--) {
            switch (word.charAt(i)) {
                case 'a', 'e', 'i', 'u', 'o' -> ans += left * right;
            }
        }
        return ans;
    }
}
