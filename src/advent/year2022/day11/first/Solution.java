package advent.year2022.day11.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Function;

import static java.math.BigInteger.ZERO;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    private static final int TOTAL_ROUND = 20;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day11/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day11/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Monkey> monkeys = new ArrayList<>();

            while (scanner.hasNextLine()) {
                scanner.nextLine();
                Deque<BigInteger> items = parseItems(scanner.nextLine().trim());
                Function<BigInteger, BigInteger> function = parseFunction(scanner.nextLine());
                BigInteger divisor = new BigInteger(scanner.nextLine().trim().split(" ")[3]);
                int trueMonkey = Integer.parseInt(scanner.nextLine().trim().split(" ")[5]);
                int falseMonkey = Integer.parseInt(scanner.nextLine().trim().split(" ")[5]);
                scanner.nextLine();
                monkeys.add(new Monkey(items, function, divisor, trueMonkey, falseMonkey));
            }

            int monkeyNumber = monkeys.size();
            int[] countInspections = new int[monkeyNumber];
            for (int round = 0; round < TOTAL_ROUND; round++) {
                for (int i = 0; i < monkeyNumber; i++) {
                    Monkey monkey = monkeys.get(i);
                    Deque<BigInteger> deque = monkey.deque;
                    BigInteger divisor = monkey.divisor;
                    Function<BigInteger, BigInteger> function = monkey.function;
                    Deque<BigInteger> trueMonkey = monkeys.get(monkey.trueMonkey).deque;
                    Deque<BigInteger> falseMonkey = monkeys.get(monkey.falseMonkey).deque;
                    countInspections[i] += deque.size();
                    while (!deque.isEmpty()) {
                        BigInteger item = deque.pollFirst();
                        BigInteger newWorry = function.apply(item).divide(BigInteger.valueOf(3));
                        if (newWorry.mod(divisor).equals(ZERO)) trueMonkey.addLast(newWorry);
                        else falseMonkey.addLast(newWorry);
                    }
                }
            }
            long ans = 0;
            int max1 = 0, max2 = 0;
            for (int val : countInspections) {
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
        final Deque<BigInteger> deque;
        final Function<BigInteger, BigInteger> function;
        final BigInteger divisor;
        final int trueMonkey, falseMonkey;

        private Monkey(Deque<BigInteger> deque, Function<BigInteger, BigInteger> function, BigInteger divisor, int trueMonkey, int falseMonkey) {
            this.deque = deque;
            this.function = function;
            this.divisor = divisor;
            this.trueMonkey = trueMonkey;
            this.falseMonkey = falseMonkey;
        }
    }

    private static Deque<BigInteger> parseItems(String s) {
        int pos = s.indexOf(":");
        String[] itemParts = s.substring(pos + 2).split(", ");
        Deque<BigInteger> items = new ArrayDeque<>();
        for (String itemPart : itemParts) items.addLast(new BigInteger(itemPart));
        return items;
    }

    private static Function<BigInteger, BigInteger> parseFunction(String s) {
        int pos = s.indexOf("=");
        String[] functionParts = s.substring(pos + 2).split(" ");
        boolean firstIsOld = functionParts[0].equals("old");
        BigInteger firstAlternative = firstIsOld ? ZERO : new BigInteger(functionParts[0]);
        boolean secondIsOld = functionParts[2].equals("old");
        BigInteger secondAlternative = secondIsOld ? ZERO : new BigInteger(functionParts[2]);
        return switch (functionParts[1]) {
            case "+" -> (x) -> (firstIsOld ? x : firstAlternative).add(secondIsOld ? x : secondAlternative);
            case "*" -> (x) -> (firstIsOld ? x : firstAlternative).multiply(secondIsOld ? x : secondAlternative);
            default -> throw new IllegalArgumentException();
        };
    }
}
