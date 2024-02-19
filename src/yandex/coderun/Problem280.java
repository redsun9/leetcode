package yandex.coderun;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Problem280 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            int cPos = s.indexOf(' ');
            int a = Integer.parseInt(s, 0, cPos, 10);
            int b = Integer.parseInt(s, cPos + 1, s.length(), 10);
            arr[i][0] = Math.max(a, b);
            arr[i][1] = Math.min(a, b);
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int ans = 0, maxHeight = 0;
        for (int i = n - 1, j = n - 1; i >= 0; i--) {
            if (arr[i][1] < maxHeight) continue;
            while (arr[i][0] < arr[j][0]) maxHeight = Math.max(maxHeight, arr[j--][1]);
            if (arr[i][1] >= maxHeight) ans++;
        }
        writer.write(Integer.toString(ans));
        reader.close();
        writer.close();
    }
}
