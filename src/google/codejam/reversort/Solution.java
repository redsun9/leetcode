package google.codejam.reversort;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int t1 = 0; t1 < t; t1++) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }
            int ans = countWeight(a);
            System.out.printf("Case #%d: %d\n", (t1 + 1), ans);
        }
    }

    public static int countWeight(int[] a) {
        int n = a.length;
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) {
            pos[a[i] - 1] = i;
        }
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += (pos[i] - i + 1);
            swap(a, pos, i, pos[i]);
        }
        return ans;
    }

    private static void swap(int[] a, int[] pos, int start, int end) {
        int tmp;
        while (start < end) {
            tmp = a[end];
            a[end] = a[start];
            a[start] = tmp;
            pos[a[end] - 1] = end;
            pos[a[start] - 1] = start;
            start++;
            end--;
        }
    }
}
