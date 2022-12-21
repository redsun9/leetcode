package advent.year2022.day21.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.LongBinaryOperator;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day21/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day21/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Map<String, Monkey> map = new HashMap<>();
            while (scanner.hasNextLine()) {
                Monkey monkey = parse(scanner.nextLine().trim());
                map.put(monkey.name, monkey);
            }
            Stack<Monkey> stack = new Stack<>();
            stack.push(map.get("root"));
            while (!stack.isEmpty()) {
                Monkey monkey = stack.peek();
                if (monkey.val != null) stack.pop();
                else {
                    Monkey left = map.get(monkey.left);
                    if (left.val == null && !left.visited) {
                        left.visited = true;
                        stack.push(left);
                    }
                    Monkey right = map.get(monkey.right);
                    if (right.val == null && !right.visited) {
                        right.visited = true;
                        stack.push(right);
                    }
                    if (left.val != null && right.val != null) {
                        monkey.val = monkey.operator.applyAsLong(left.val, right.val);
                        stack.pop();
                    }
                }
            }
            printer.println(map.get("root").val);
        }
    }

    private static Monkey parse(String s) {
        String[] split = s.split(" ");
        if (split.length == 2) return new Monkey(
                split[0].substring(0, split[0].length() - 1),
                Integer.parseInt(split[1])
        );
        else {
            LongBinaryOperator operator = switch (split[2]) {
                case "*" -> (x, y) -> x * y;
                case "/" -> (x, y) -> x / y;
                case "+" -> Long::sum;
                default -> (x, y) -> x - y;
            };
            return new Monkey(
                    split[0].substring(0, split[0].length() - 1),
                    split[1],
                    split[3],
                    operator
            );
        }

    }

    private static class Monkey {
        final String name, left, right;
        final LongBinaryOperator operator;
        Long val;
        boolean visited = false;

        Monkey(String name, long val) {
            this.name = name;
            this.val = val;
            this.left = null;
            this.right = null;
            this.operator = null;
        }

        Monkey(String name, String left, String right, LongBinaryOperator operator) {
            this.name = name;
            this.left = left;
            this.right = right;
            this.operator = operator;
            this.val = null;
        }

    }
}
