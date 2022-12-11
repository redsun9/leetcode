package advent.year2022.day11.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.LongFunction;


@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int TOTAL_ROUND = 10_000;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day11/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day11/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Monkey> monkeys = new ArrayList<>();

            long lcm = 1;

            while (scanner.hasNextLine()) {
                scanner.nextLine();

                String s1 = scanner.nextLine().trim();
                int pos1 = s1.indexOf(":");
                String[] itemParts = s1.substring(pos1 + 2).split(", ");
                Deque<Long> items = new ArrayDeque<>();
                for (String itemPart : itemParts) items.addLast(Long.parseLong(itemPart));

                String s = scanner.nextLine();
                int pos = s.indexOf("=");
                String[] functionParts = s.substring(pos + 2).split(" ");
                boolean firstIsOld = functionParts[0].equals("old");
                final long firstAlternative = firstIsOld ? 0L : Long.parseLong(functionParts[0]);
                boolean secondIsOld = functionParts[2].equals("old");
                final long secondAlternative = secondIsOld ? 0L : Long.parseLong(functionParts[2]);
                boolean multiply = functionParts[1].equals("*");
                LongFunction<Long> function = x -> multiply
                        ? (firstIsOld ? x : firstAlternative) * (secondIsOld ? x : secondAlternative)
                        : (firstIsOld ? x : firstAlternative) + (secondIsOld ? x : secondAlternative);

                long divisor = Long.parseLong(scanner.nextLine().trim().split(" ")[3]);
                lcm = lcm(lcm, divisor);
                int trueMonkey = Integer.parseInt(scanner.nextLine().trim().split(" ")[5]);
                int falseMonkey = Integer.parseInt(scanner.nextLine().trim().split(" ")[5]);

                monkeys.add(new Monkey(items, function, divisor, trueMonkey, falseMonkey));
                scanner.nextLine();
            }

            int monkeyNumber = monkeys.size();
            long[] countInspections = new long[monkeyNumber];
            for (int round = 0; round < TOTAL_ROUND; round++) {
                for (int i = 0; i < monkeyNumber; i++) {
                    Monkey monkey = monkeys.get(i);
                    Deque<Long> deque = monkey.deque;
                    long divisor = monkey.divisor;
                    LongFunction<Long> function = monkey.function;
                    Deque<Long> trueMonkey = monkeys.get(monkey.trueMonkey).deque;
                    Deque<Long> falseMonkey = monkeys.get(monkey.falseMonkey).deque;
                    countInspections[i] += deque.size();
                    while (!deque.isEmpty()) {
                        long item = deque.pollFirst();
                        long newWorry = function.apply(item) % lcm;
                        if (newWorry % divisor == 0L) trueMonkey.addLast(newWorry);
                        else falseMonkey.addLast(newWorry);
                    }
                }
            }
            long max1 = 0, max2 = 0;
            for (long val : countInspections) {
                if (val <= max2) continue;
                if (val > max1) {
                    max2 = max1;
                    max1 = val;
                } else max2 = val;
            }

            printer.println(max1 * max2);
        }
    }

    private static class Monkey {
        final Deque<Long> deque;
        final LongFunction<Long> function;
        final long divisor;
        final int trueMonkey, falseMonkey;

        private Monkey(Deque<Long> deque, LongFunction<Long> function, long divisor, int trueMonkey, int falseMonkey) {
            this.deque = deque;
            this.function = function;
            this.divisor = divisor;
            this.trueMonkey = trueMonkey;
            this.falseMonkey = falseMonkey;
        }
    }

    public static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }
}
