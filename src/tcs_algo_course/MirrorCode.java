package tcs_algo_course;

import java.io.IOException;
import java.util.Scanner;

public class MirrorCode {
    private static final int ALPHABET = 26;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int[] cnt = new int[ALPHABET];
        String s = scanner.nextLine();
        for (int i = 0; i < n; i++) cnt[s.charAt(i) - 'A']++;

        int minOdd = 0;
        while (minOdd < ALPHABET && (cnt[minOdd] & 1) == 0) minOdd++;

        for (int i = 0; i < ALPHABET; i++) {
            int k = cnt[i] >> 1;
            char c = (char) ('A' + i);
            for (int j = 0; j < k; j++) System.out.print(c);
        }

        if (minOdd != ALPHABET) System.out.print((char) ('A' + minOdd));
        for (int i = ALPHABET - 1; i >= 0; i--) {
            int k = cnt[i] >> 1;
            char c = (char) ('A' + i);
            for (int j = 0; j < k; j++) System.out.print(c);
        }
        System.out.println();
    }
}
