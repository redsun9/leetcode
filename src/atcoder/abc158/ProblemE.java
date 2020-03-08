package atcoder.abc158;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int p = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine().trim();
        System.out.println(numberOfDivisibleSubstrings(s, p));
    }

    public static long numberOfDivisibleSubstrings(String s, int p) {
        long[] currentMods = new long[p];
        long[] previousMods = new long[p];
        long[] tmp;
        long counter = 0;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            for (int i = 0; i < p; i++) {
                currentMods[(i * 10 + digit) % p] += previousMods[i];
            }
            currentMods[digit % p]++;
            counter += currentMods[0];
            tmp = currentMods;
            currentMods = previousMods;
            previousMods = tmp;
            Arrays.fill(currentMods, 0);
        }
        return counter;
    }
}
