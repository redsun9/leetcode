package leetcode.leetcode8xx.leetcode843;

import java.util.Random;

public class Solution {
    private final Random random = new Random();
    private final Picker picker;
    private final int maxTries;

    public Solution(Picker picker, int maxTries) {
        this.picker = picker;
        this.maxTries = maxTries;
    }

    public void findSecretWord(String[] w, Master master) {
        int m = w.length;
        if (m == 1) {
            master.guess(w[0]);
            return;
        }
//        shuffle(w);
        int n = w[0].length();
        int[][] a = new int[m][m];
        for (int i = 0; i < m; i++) {
            String s1 = w[i];
            a[i][i] = n;
            for (int j = 0; j < i; j++) {
                String s2 = w[j];
                int count = 0;
                for (int k = 0; k < n; k++) {
                    if (s1.charAt(k) == s2.charAt(k)) count++;
                }
                a[i][j] = count;
                a[j][i] = count;
            }
        }
        boolean[] removed = new boolean[m];
        int candidates = m;
        int triesLeft = maxTries;
        while (candidates != 0 && triesLeft != 0) {
            int i = picker.pickNext(a, removed, m, n, candidates);
            int guess = master.guess(w[i]);
            triesLeft--;
            if (!removed[i]) candidates--;
            removed[i] = true;
            if (guess == n) candidates = 0;
            else {
                for (int j = 0; j < m; j++) {
                    if (a[i][j] != guess && !removed[j]) {
                        candidates--;
                        removed[j] = true;
                    }
                }
            }
        }
    }

    private void shuffle(String[] a) {
        for (int i = a.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            String t = a[j];
            a[j] = a[i];
            a[i] = t;
        }
    }
}
