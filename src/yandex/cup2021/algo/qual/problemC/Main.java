package yandex.cup2021.algo.qual.problemC;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int[] a = new int[k], b = new int[k];
        read1dArray(scanner, a, k);
        read1dArray(scanner, b, k);
        int total = 0;
        for (int val : a) total += val;

        int n = total;
        int notCommonLength = 0;

        for (int i = 0; i < k; i++) {
            notCommonLength -= b[i];
            if (b[i] != 0) n = Math.min(n, a[i] / b[i]);
        }

        while (total % n != 0) n--;
        notCommonLength += total / n;


        int[] left = new int[k];
        for (int i = 0; i < k; i++) left[i] = a[i] - n * b[i];


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < b[i]; j++) {
                sb.append(i + 1).append(' ');
            }
        }

        String common = sb.toString();

        System.out.println(n + " " + total / n);
        for (int i = 0, curLeft = 0; i < n; i++) {
            System.out.print(common);
            int tmp = notCommonLength;
            while (tmp != 0) {
                int used = Math.min(left[curLeft], tmp);
                for (int j = 0; j < used; j++) System.out.print((curLeft + 1) + " ");
                tmp -= used;
                left[curLeft] -= used;
                if (left[curLeft] == 0) curLeft++;
            }
            System.out.println();
        }
    }


    private static void read1dArray(Scanner scanner, int[] a, int n) {
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
    }
}
