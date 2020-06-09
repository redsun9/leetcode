package leetcode.leetcode8xx.leetcode843;

import java.util.Random;

public class RandomPicker implements Picker {
    private final Random random = new Random();

    @Override
    public int pickNext(int[][] a, boolean[] removed, int m, int n, int candidates) {
        int c = random.nextInt(candidates);
        int i = 0;
        while (true) {
            if (!removed[i]) {
                if (c-- == 0) return i;
            }
            i++;
        }
    }
}
