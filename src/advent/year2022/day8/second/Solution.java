package advent.year2022.day8.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day8/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day8/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());

            int m = list.size(), n = list.get(0).length();

            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                String s = list.get(i);
                for (int j = 0; j < n; j++) {
                    arr[i][j] = s.charAt(j) - '0';
                }
            }

            int[][] l = new int[m][n], r = new int[m][n], u = new int[n][m], d = new int[n][m];
            for (int i = 0; i < m; i++) {
                l[i] = canSee(arr[i]);

                reverse(arr[i]);
                r[i] = canSee(arr[i]);
                reverse(r[i]);
                reverse(arr[i]);
            }

            for (int j = 0; j < n; j++) {
                int[] column = column(arr, j);
                u[j] = canSee(column);

                reverse(column);
                d[j] = canSee(column);
                reverse(d[j]);
            }


            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, l[i][j] * r[i][j] * u[j][i] * d[j][i]);
                }
            }
            printer.println(ans);
        }
    }

    private static int[] canSee(int[] h) {
        int n = h.length;
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            int canSee = 1;
            while (canSee != i && h[i] > h[i - canSee]) canSee += ans[i - canSee];
            ans[i] = canSee;
        }
        return ans;
    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
    }

    private static int[] column(int[][] arr, int i) {
        int n = arr.length;
        int[] ans = new int[n];
        for (int j = 0; j < n; j++) {
            ans[j] = arr[j][i];
        }
        return ans;
    }
}
