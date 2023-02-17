package tcs_algo_acourse;

import java.util.Scanner;

public class BinaryGuess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine().trim());
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi + 1) >>> 1;
            System.out.println(mid);
            System.out.flush();
            String ans = scanner.nextLine().trim();
            if (ans.charAt(0) == '<') hi = mid - 1;
            else lo = mid;
        }
        System.out.println("!" + lo);
    }
}
