package codeforces.contest1769;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class ProblemD1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        long a = parse(scanner.nextLine().trim());
        long b = parse(scanner.nextLine().trim());
        int ans = solve(a, b, new HashMap<>());
        if (ans > 0) printer.println("Alice");
        else printer.println("Bob");
    }

    private static long parse(String s) {
        long a = 0;
        for (int i = 0; i < 18; i++) {
            int value = value(s.charAt(3 * i));
            int color = color(s.charAt(3 * i + 1));
            a |= 1L << (color * 9 + value);
        }
        return a;
    }

    private static int color(char c) {
        return switch (c) {
            case 'C' -> 0;
            case 'D' -> 1;
            case 'S' -> 2;
            default -> 3;
        };
    }

    private static int value(char c) {
        return switch (c) {
            case '6' -> 0;
            case '7' -> 1;
            case '8' -> 2;
            case '9' -> 3;
            case 'T' -> 4;
            case 'J' -> 5;
            case 'Q' -> 6;
            case 'K' -> 7;
            default -> 8;
        };
    }

    public static int solve(long a, long b, Map<State, Integer> cache) {
        if (Long.bitCount(a) == 0) return Long.bitCount(b);
        if (Long.bitCount(b) == 0) return -Long.bitCount(a);

        State state = new State(a, b);

        Integer max = cache.get(state);
        if (max == null) {
            max = Integer.MIN_VALUE;
            long both = a | b;

            boolean hasMove = false;

            for (int color = 0; color < 4; color++) {
                //from 0 to 2 check +1
                for (int val = 0, bitFrom = color * 9 + val; val <= 2; val++, bitFrom++) {
                    if ((a >> bitFrom & 1) == 1 && (both >> (bitFrom + 1) & 1) == 0) {
                        max = Math.max(max, -solve(b, a ^ 1L << bitFrom, cache));
                        hasMove = true;
                    }
                }
                for (int val = 4, bitFrom = color * 9 + val; val <= 8; val++, bitFrom++) {
                    if ((a >> bitFrom & 1) == 1 && (both >> (bitFrom - 1) & 1) == 0) {
                        max = Math.max(max, -solve(b, a ^ 1L << bitFrom, cache));
                        hasMove = true;
                    }
                }

                if (((a >> (color * 9 + 3) & 1) == 1)) {
                    max = Math.max(max, -solve(b, a ^ 1L << (color * 9 + 3), cache));
                    hasMove = true;
                }
            }
            if (!hasMove) max = -solve(b, a, cache);
            cache.put(state, max);
        }
        return max;
    }

    public record State(long a, long b) {
    }
}
