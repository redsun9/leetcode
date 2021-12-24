package advent.day24;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.LongBinaryOperator;
import java.util.function.LongUnaryOperator;

public class Solution {
    private static final LongBinaryOperator reducer = Math::min;    //change to Math::max for the first part
    private static final long initialValue = Long.MAX_VALUE;        //change to 0 for the first part

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day24/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day24/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long start = System.currentTimeMillis();
            ConcurrentHashMap<State, Long> prev = new ConcurrentHashMap<>(Map.of(new State(new long[4]), 0L));
            int instructionCount = 0;
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().trim().split(" ");
                instructionCount++;
                int aReg = s[1].charAt(0) - 'w';
                ConcurrentHashMap<State, Long> next = new ConcurrentHashMap<>();
                if (s[0].equals("inp")) {
                    prev.entrySet().stream().parallel().forEach(entry -> {
                        for (int digit = 1; digit <= 9; digit++) {
                            long[] newArr = Arrays.copyOf(entry.getKey().a, 4);
                            long newVal = entry.getValue() * 10 + digit;
                            newArr[aReg] = digit;
                            next.compute(
                                    new State(newArr),
                                    (k, v) -> v == null ? newVal : reducer.applyAsLong(v, newVal)
                            );
                        }
                    });
                } else {
                    if (s[2].charAt(0) >= 'a' && s[2].charAt(0) <= 'z') {
                        int bReg = s[2].charAt(0) - 'w';
                        final LongBinaryOperator binaryOperator = switch (s[0]) {
                            case "add" -> Long::sum;
                            case "mul" -> (x, y) -> x * y;
                            case "div" -> (x, y) -> x / y;
                            case "mod" -> (x, y) -> x % y;
                            case "eql" -> (x, y) -> x == y ? 1 : 0;
                            default -> throw new RuntimeException();
                        };
                        prev.entrySet().stream().parallel().forEach(entry -> {
                            long[] arr = entry.getKey().a;
                            long value = entry.getValue();
                            arr[aReg] = binaryOperator.applyAsLong(arr[aReg], arr[bReg]);
                            next.compute(entry.getKey(), (k, v) -> v == null ? value : reducer.applyAsLong(v, value));
                        });
                    } else {
                        int bVal = Integer.parseInt(s[2]);
                        LongUnaryOperator unaryOperator = switch (s[0]) {
                            case "add" -> x -> x + bVal;
                            case "mul" -> x -> x * bVal;
                            case "div" -> x -> x / bVal;
                            case "mod" -> x -> x % bVal;
                            case "eql" -> x -> x == bVal ? 1 : 0;
                            default -> throw new RuntimeException();
                        };
                        prev.entrySet().stream().parallel().forEach(entry -> {
                            long[] arr = entry.getKey().a;
                            long value = entry.getValue();
                            arr[aReg] = unaryOperator.applyAsLong(arr[aReg]);
                            next.compute(entry.getKey(), (k, v) -> v == null ? value : reducer.applyAsLong(v, value));
                        });
                    }
                }
                prev = next;
                System.out.println("instr - " + instructionCount + ", size - " + next.size());
            }

            long ans = initialValue;
            for (Map.Entry<State, Long> entry : prev.entrySet()) {
                if (entry.getKey().a[3] == 0) ans = reducer.applyAsLong(ans, entry.getValue());
            }
            printer.println(ans);
            long end = System.currentTimeMillis();
            System.out.println(end - start);
        }
    }

    private static class State {
        long[] a;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Arrays.equals(a, state.a);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(a);
        }

        public State(long[] a) {
            this.a = a;
        }
    }
}
