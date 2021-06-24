package ege;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem73 {
    private static final int p = 67;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/ege/27.txt");
        ) {
            Scanner scanner = new Scanner(fis);
            int n = Integer.parseInt(scanner.nextLine());
            long[] minPrefSum = new long[p];
            int[] minPrefSumIdx = new int[p];
            Arrays.fill(minPrefSumIdx, -1);
            minPrefSumIdx[0] = 0;
            long currentSum = 0;
            int ans = 0;
            long maxSum = 0;

            for (int i = 1; i <= n; i++) {
                currentSum += Long.parseLong(scanner.nextLine());
                int currentMod = (int) ((currentSum % p + p) % p);

                if (minPrefSumIdx[currentMod] != -1) {
                    long tmp = currentSum - minPrefSum[currentMod];
                    if (tmp > maxSum) {
                        maxSum = tmp;
                        ans = i - minPrefSumIdx[currentMod];
                    }
                    if (currentSum < minPrefSum[currentMod]) {
                        minPrefSum[currentMod] = currentSum;
                        minPrefSumIdx[currentMod] = i;
                    }
                } else {
                    minPrefSum[currentMod] = currentSum;
                    minPrefSumIdx[currentMod] = i;
                }
            }
            System.out.println(ans);

        }
    }
}
