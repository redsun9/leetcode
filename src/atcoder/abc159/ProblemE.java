package atcoder.abc159;

import java.util.ArrayList;
import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int w = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        boolean[][] c = new boolean[h][w];
        int totalCount = 0;
        for (int i = 0; i < h; i++) {
            char[] chars = scanner.nextLine().toCharArray();
            for (int j = 0; j < w; j++) {
                if (chars[j] == '1') {
                    c[i][j] = true;
                    totalCount++;
                }
            }
        }

        if (totalCount <= k) {
            System.out.println(0);
            return;
        }
        //number in [0;i)[0;j)
        int[][] count = new int[h + 1][w + 1];
        for (int i = 0; i < h + 1; i++) {
            count[i][0] = 0;
        }
        for (int i = 0; i < w + 1; i++) {
            count[0][i] = 0;
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                count[i + 1][j + 1] = count[i + 1][j] + count[i][j + 1] - count[i][j] + (c[i][j] ? 1 : 0);
            }
        }
        int ans = Integer.MAX_VALUE;
        int maxMask = (1 << (h - 1)) - 1;
        for (int mask = 0; mask <= maxMask; mask++) {
            ArrayList<int[]> heights = new ArrayList<>();
            int start = 0;
            for (int j = 0; j < h - 1; j++) {
                if ((mask & (1 << j)) != 0) {
                    heights.add(new int[]{start, j});
                    start = j + 1;
                }
            }
            heights.add(new int[]{start, h - 1});
            int stripNumber = heights.size();
            int nCuts = 0;
            int[] curNumber = new int[stripNumber];
            int[] prevNumber = new int[stripNumber];
            boolean failed = false;
            for (int j = 0; j < w; j++) {
                //проверяем, что можно вписать для каждой полоски
                boolean shouldCut = false;
                for (int i = 0; i < stripNumber; i++) {
                    int dop = count[heights.get(i)[1] + 1][j + 1] - count[heights.get(i)[0]][j + 1] - count[heights.get(i)[1] + 1][j] + count[heights.get(i)[0]][j];
                    if (dop > k) {
                        failed = true;
                        break;
                    }
                    curNumber[i] = prevNumber[i] + dop;
                    if (prevNumber[i] + dop > k) {
                        shouldCut = true;
                    }
                }
                if (failed) break;
                if (shouldCut) {
                    nCuts++;
                    for (int i = 0; i < stripNumber; i++) {
                        curNumber[i] = curNumber[i] - prevNumber[i];
                    }
                }
                int[] tmp = curNumber;
                curNumber = prevNumber;
                prevNumber = tmp;
            }

            if (!failed) {
                ans = Math.min(ans, nCuts + stripNumber - 1);
                if (ans == 1) break;
            }
        }
        System.out.println(ans);
    }
}
