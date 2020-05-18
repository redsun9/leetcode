package leetcode.leetcode5xx.leetcode567;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int n = s2.length();
        if (n < k) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) {
            count[c - 'a']++;
        }
        char[] chars = s2.toCharArray();
        for (int i = 0; i < k; i++) {
            count[chars[i] - 'a']--;
        }
        int numberOfOk = 0;
        for (int a : count) if (a == 0) numberOfOk++;
        if (numberOfOk == 26) return true;
        for (int i = k, j = 0; i < n; i++, j++) {
            int c1 = chars[j] - 'a';
            int c2 = chars[i] - 'a';
            if (count[c1] == 0) numberOfOk--;
            count[c1]++;
            if (count[c1] == 0) numberOfOk++;

            if (count[c2] == 0) numberOfOk--;
            count[c2]--;
            if (count[c2] == 0) numberOfOk++;

            if (numberOfOk == 26) return true;
        }
        return false;
    }
}
