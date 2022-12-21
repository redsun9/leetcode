package advent.year2022.day21.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.LongBinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day21/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day21/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Map<String, Monkey> map = new HashMap<>();
            while (scanner.hasNextLine()) {
                Monkey monkey = parse(scanner.nextLine().trim());
                map.put(monkey.name, monkey);
            }
            Stack<Monkey> stack = new Stack<>();
            Monkey root = map.get("root");
            root = new Monkey(
                    "root",
                    root.left, root.right,
                    (a, b) -> a - b,
                    Solution::solveMinusLeft,
                    Solution::solveMinusRight
            );
            map.put("root", root);

            stack.push(root);
            while (!stack.isEmpty()) {
                Monkey monkey = stack.peek();
                if (monkey.val != null || monkey.left == null || monkey.right == null || monkey.processed) {
                    monkey.processed = true;
                    stack.pop();
                } else {
                    Monkey left = map.get(monkey.left);
                    if (left.val == null && !left.processed) {
                        left.visited = true;
                        stack.push(left);
                    }
                    Monkey right = map.get(monkey.right);
                    if (right.val == null && !right.processed) {
                        right.visited = true;
                        stack.push(right);
                    }
                    if (left.val != null && right.val != null) {
                        monkey.val = monkey.operator.applyAsLong(left.val, right.val);
                        monkey.processed = true;
                        stack.pop();
                    } else if (left.processed && right.processed) {
                        monkey.processed = true;
                        stack.pop();
                    }
                }
            }

            List<Long> list = List.of(0L);
            while (!root.name.equals("humn")) {
                Monkey left = map.get(root.left);
                Monkey right = map.get(root.right);
                if (left.val == null) {
                    list = root.solveLeftOperator.apply(list, right.val);
                    root = left;
                } else {
                    list = root.solveRightOperator.apply(list, left.val);
                    root = right;
                }
            }

            printer.println(list.get(0));
        }
    }

    private static Monkey parse(String s) {
        String[] split = s.split(" ");
        String name = split[0].substring(0, split[0].length() - 1);
        if (name.equals("humn")) return new Monkey("humn");
        else if (split.length == 2) return new Monkey(name, Long.parseLong(split[1]));
        else {
            LongBinaryOperator operator = switch (split[2]) {
                case "*" -> (a, b) -> a * b;
                case "/" -> (a, b) -> a / b;
                case "+" -> (a, b) -> a + b;
                default -> (a, b) -> a - b;
            };
            BiFunction<List<Long>, Long, List<Long>> leftOperator = switch (split[2]) {
                case "*" -> Solution::solveMultiply;
                case "/" -> Solution::solveDivideLeft;
                case "+" -> Solution::solvePlus;
                default -> Solution::solveMinusLeft;
            };
            BiFunction<List<Long>, Long, List<Long>> rightOperator = switch (split[2]) {
                case "*" -> Solution::solveMultiply;
                case "/" -> Solution::solveDivideRight;
                case "+" -> Solution::solvePlus;
                default -> Solution::solveMinusRight;
            };

            return new Monkey(name, split[1], split[3], operator, leftOperator, rightOperator);
        }
    }

    private static List<Long> solvePlus(List<Long> listAns, long other) {
        return listAns.stream().map(it -> it - other).collect(Collectors.toList());
    }

    private static List<Long> solveMultiply(List<Long> ListAns, long other) {
        if (other == 0) throw new IllegalArgumentException("x*r=ans, where r=0");
        return ListAns.stream().filter(it -> it % other == 0).map(it -> it / other).collect(Collectors.toList());
    }

    private static List<Long> solveMinusLeft(List<Long> listAns, long right) {
        return listAns.stream().map(it -> it + right).collect(Collectors.toList());
    }

    private static List<Long> solveMinusRight(List<Long> list, long left) {
        return list.stream().map(it -> left - it).collect(Collectors.toList());
    }

    private static List<Long> solveDivideLeft(List<Long> list, long right) {
        return list.stream().flatMap(it -> LongStream.rangeClosed(it * right, it * right + right - 1).boxed())
                .distinct().collect(Collectors.toList());
    }

    private static List<Long> solveDivideRight(List<Long> list, long left) {
        return list.stream().flatMap(it -> {
            if (it < 0) {
                if (left % it == 0) return Stream.of(left / it);
                else return Stream.empty();
            } else if (it == 0) {
                return LongStream.rangeClosed(Math.abs(left) + 1, Math.abs(left) + 1000L).boxed();
            } else {
                long x1 = left / it;
                long x2 = (left - 1 + it) / (it + 1);
                if (x2 <= x1) return LongStream.rangeClosed(x2, x1).boxed();
                else return Stream.empty();
            }
        }).distinct().collect(Collectors.toList());
    }

    private static class Monkey {
        final String name, left, right;
        final LongBinaryOperator operator;
        final BiFunction<List<Long>, Long, List<Long>> solveLeftOperator, solveRightOperator;
        Long val;
        boolean visited = false, processed = false;

        Monkey(String name) {
            this.name = name;
            this.right = null;
            this.left = null;
            this.val = null;
            this.operator = null;
            this.solveLeftOperator = null;
            this.solveRightOperator = null;
        }

        Monkey(String name, long val) {
            this.name = name;
            this.val = val;
            this.left = null;
            this.right = null;
            this.operator = null;
            this.solveLeftOperator = null;
            this.solveRightOperator = null;
            this.visited = true;
            this.processed = true;
        }

        Monkey(
                String name, String left, String right, LongBinaryOperator operator,
                BiFunction<List<Long>, Long, List<Long>> solveLeftOperator,
                BiFunction<List<Long>, Long, List<Long>> solveRightOperator
        ) {
            this.name = name;
            this.left = left;
            this.right = right;
            this.operator = operator;
            this.solveLeftOperator = solveLeftOperator;
            this.solveRightOperator = solveRightOperator;
            this.val = null;
        }
    }
}
