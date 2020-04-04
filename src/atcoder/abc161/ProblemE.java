package atcoder.abc161;

import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        char[] chars = scanner.nextLine().toCharArray();
        boolean[] canWork = new boolean[n];
        for (int i = 0; i < n; i++) {
            canWork[i] = chars[i] == 'o';
        }
        if (c == 0) {
            int count = 0;
            for (boolean b : canWork) if (b) count++;
            if (k == count) {
                for (int i = 0; i < n; i++) {
                    if (canWork[i]) {
                        System.out.println(i + 1);
                    }
                }
            }
            return;
        } else {
            int[] lg = new int[k];
            int[] rg = new int[k];
            int counter = 0;
            int i = 0;
            while (counter < k) {
                while (!canWork[i]) i++;
                lg[counter] = i;
                i += c + 1;
                counter++;
            }
            counter = k - 1;
            i = n - 1;
            while (counter >= 0) {
                while (!canWork[i]) i--;
                rg[counter] = i;
                i -= c + 1;
                counter--;
            }
            for (int j = 0; j < k; j++) {
                if (lg[j] == rg[j]) System.out.println(lg[j] + 1);
            }
        }
    }
}
