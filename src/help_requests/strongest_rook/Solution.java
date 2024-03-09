package help_requests.strongest_rook;

import java.util.Arrays;
import java.util.Random;

// place rook, so the sum of all cells under attack will be maximum
public class Solution {
    public static Answer maxRook(int[][] a) {
        int m = a.length, n = a[0].length;
        long[] sumRow = new long[m], sumCol = new long[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sumRow[i] += a[i][j];
                sumCol[j] += a[i][j];
            }
        }
        Answer ans = new Answer(-1, -1, Long.MIN_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                long tmp = sumRow[i] + sumCol[j] - a[i][j];
                if (tmp > ans.ans) ans = new Answer(i, j, tmp);
            }
        }
        return ans;
    }

    public record Answer(int i, int j, long ans) {
    }


    //Answer[i=799, j=724, ans=998789825]
    //Answer[i=549, j=683, ans=847327801]
    //Answer[i=466, j=662, ans=784040084]
    //Answer[i=425, j=650, ans=743576000]
    //Answer[i=325, j=655, ans=480152850]
    //[[7, 8, 5], [3, 9, 3], [9, 4, 7]] => Answer[i=2, j=1, ans=37]
    //[[7, 2, 2], [7, 9, 5], [6, 2, 2]] => Answer[i=1, j=0, ans=34]
    //[[5, 7, 3], [2, 7, 7], [7, 1, 8]] => Answer[i=0, j=2, ans=30]
    //[[6, 3, 7], [8, 7, 1], [4, 8, 2]] => Answer[i=0, j=1, ans=31]
    //[[9, 8, 4], [2, 4, 4], [8, 2, 4]] => Answer[i=0, j=0, ans=31]
    //[[9, 2, 9], [6, 4, 9], [5, 9, 9]] => Answer[i=2, j=2, ans=41]
    //[[8, 7, 9], [1, 2, 9], [3, 8, 5]] => Answer[i=0, j=2, ans=38]
    //[[8, 3, 7], [5, 2, 2], [2, 6, 1]] => Answer[i=0, j=1, ans=26]
    //[[2, 8, 2], [8, 7, 6], [7, 9, 3]] => Answer[i=1, j=1, ans=38]
    //[[2, 2, 8], [5, 9, 1], [3, 7, 8]] => Answer[i=1, j=2, ans=31]
    public static void main(String[] args) {
        int[][] coef = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}, {4, 5, 6}, {10, 9, 11}};
        int m = 1000, n = 1000;
        for (int[] c : coef) {
            int[][] a = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    a[i][j] = c[0] * (i + 100) * (200 - i) + c[1] * (j - 300) * (400 - j) + c[2] * i * j;
                }
            }
            Answer answer = maxRook(a);
            System.out.println(answer);
        }

        int k = 10;
        for (int t = 0; t < k; t++) {
            int[][] a = new int[3][3];
            Random random = new Random(t);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    a[i][j] = random.nextInt(1, 10);
                }
            }
            Answer answer = maxRook(a);
            System.out.println(Arrays.deepToString(a) + " => " + answer);
        }
    }
}
