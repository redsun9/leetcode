package leetcode.leetcode37xx.leetcode3720;

public class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        char[] arr = s.toCharArray();
        for (char c : arr) cnt[c - 'a']++;

        int candidate = 0;
        while (candidate < n) {
            char c = target.charAt(candidate);
            if (cnt[c - 'a'] == 0) break;
            cnt[c - 'a']--;
            arr[candidate++] = c;
        }

        if (candidate == n) cnt[target.charAt(--candidate) - 'a']++;

        boolean ok = false;
        while (candidate >= 0) {
            char c = target.charAt(candidate);
            for (int i = c - 'a' + 1; i < 26; i++) {
                if (cnt[i] != 0) {
                    cnt[i]--;
                    arr[candidate] = (char) (i + 'a');
                    ok = true;
                    break;
                }
            }
            if (ok) break;
            candidate--;
            if (candidate >= 0) cnt[target.charAt(candidate) - 'a']++;
        }

        if (!ok) return "";

        for (int i = candidate + 1, j = 0; i < n; i++) {
            while (cnt[j] == 0) j++;
            cnt[j]--;
            arr[i] = (char) (j + 'a');
        }
        return new String(arr);
    }
}
