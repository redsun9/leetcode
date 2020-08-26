package firecode;

import java.util.ArrayList;

public class Snake {
    public static ArrayList<Integer> findSpiral(int[][] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = arr.length;
        if (m == 0) return ans;
        int n = arr[0].length;
        if (n == 0) return ans;
        int counter = m * n;
        int k = 0;
        while (true) {
            if (counter <= 0) break;
            for (int i = k; i <= n - 1 - k; i++) ans.add(arr[k][i]);
            counter -= n - 2 * k;

            if (counter <= 0) break;
            for (int i = k + 1; i <= m - 1 - k; i++) ans.add(arr[i][n - 1 - k]);
            counter -= m - 2 * k - 1;

            if (counter <= 0) break;
            for (int i = n - 2 - k; i >= k; i--) ans.add(arr[m - 1 - k][i]);
            counter -= n - 2 * k - 1;

            if (counter <= 0) break;
            for (int i = m - 2 - k; i >= k + 1; i--) ans.add(arr[i][k]);
            counter -= m - 2 * k - 2;
            k++;
        }
        return ans;
    }
}
