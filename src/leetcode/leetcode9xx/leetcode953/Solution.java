package leetcode.leetcode9xx.leetcode953;

public class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        if (n <= 1) return true;
        int[] ord = new int[26];
        for (int i = 0; i < 26; i++) ord[order.charAt(i) - 'a'] = i;
        for (int i = 1; i < n; i++) {
            String a = words[i - 1];
            String b = words[i];
            if (!isLower(a, b, ord)) return false;
        }
        return true;
    }

    private static boolean isLower(String a, String b, int[] order) {
        int la = a.length();
        int lb = b.length();
        int l = Math.min(la, lb);
        int j = 0;
        while (j < l) {
            int ordA = order[a.charAt(j) - 'a'];
            int ordB = order[b.charAt(j) - 'a'];
            if (ordA > ordB) return false;
            if (ordA < ordB) return true;
            j++;
        }
        return la <= lb;
    }
}
