package advent.year2022.day21.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.function.BinaryOperator;

@SuppressWarnings({"DuplicatedCode"})
public class SolutionFraction {
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
            Monkey first = map.get(root.left);
            Monkey second = map.get(root.right);
            stack.push(first);
            stack.push(second);
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
                        monkey.val = monkey.operator.apply(left.val, right.val);
                        stack.pop();
                    }
                }
            }
            printer.println(solve(first.val, second.val));
        }
    }

    private static Fraction solve(Linear first, Linear second) {
        return second.b.minus(first.b).divide(first.a.minus(second.a));
    }

    private static Monkey parse(String s) {
        String[] split = s.split(" ");
        String name = split[0].substring(0, split[0].length() - 1);
        if (name.equals("humn")) return new Monkey("humn");
        else if (split.length == 2) {
            return new Monkey(
                    name,
                    Integer.parseInt(split[1])
            );
        } else {
            BinaryOperator<Linear> operator = switch (split[2]) {
                case "*" -> Linear::multiply;
                case "/" -> Linear::divide;
                case "+" -> Linear::plus;
                default -> Linear::minus;
            };
            return new Monkey(
                    name,
                    split[1],
                    split[3],
                    operator
            );
        }

    }

    private static class Monkey {
        final String name, left, right;
        final BinaryOperator<Linear> operator;
        Linear val;
        boolean visited = false;

        Monkey(String name) {
            this.name = name;
            this.val = new Linear(Fraction.of(1), Fraction.ZERO);
            this.left = null;
            this.right = null;
            this.operator = null;
        }

        Monkey(String name, long val) {
            this.name = name;
            this.val = new Linear(Fraction.ZERO, Fraction.of(val));
            this.left = null;
            this.right = null;
            this.operator = null;
        }

        Monkey(String name, String left, String right, BinaryOperator<Linear> operator) {
            this.name = name;
            this.left = left;
            this.right = right;
            this.operator = operator;
            this.val = null;
        }
    }

    // ax+b
    private record Linear(Fraction a, Fraction b) {
        Linear plus(Linear that) {
            return new Linear(this.a.plus(that.a), this.b.plus(that.b));
        }

        Linear minus(Linear that) {
            return new Linear(this.a.minus(that.a), this.b.minus(that.b));
        }

        Linear multiply(Linear that) {
            if (!this.a.multiply(that.a).equals(Fraction.ZERO))
                throw new UnsupportedOperationException("multiply of polynomials");
            return new Linear(this.a.multiply(b).plus(that.a.multiply(this.b)), this.b.multiply(that.b));
        }

        Linear divide(Linear that) {
            if (that.a.equals(Fraction.ZERO)) return new Linear(this.a.divide(that.b), this.b.divide(that.b));
            if (this.a.multiply(that.b).equals(this.b.multiply(that.a))) {
                return new Linear(Fraction.ZERO, this.a.divide(that.a));
            }
            throw new UnsupportedOperationException("divide polynomials");
        }

    }

    // a/b
    private record Fraction(long a, long b) {
        public static final Fraction ZERO = of(0);

        static Fraction of(long a) {
            return new Fraction(a, 1);
        }

        static Fraction of(long a, long b) {
            long gcd = gcd(a, b);
            return new Fraction(a / gcd, b / gcd);
        }

        Fraction plus(Fraction that) {
            long lcm = lcm(this.b, that.b);
            return of(this.a * lcm / this.b + that.a * lcm / that.b, lcm);
        }

        Fraction minus(Fraction that) {
            long lcm = lcm(this.b, that.b);
            return of(this.a * lcm / this.b - that.a * lcm / that.b, lcm);
        }

        Fraction multiply(Fraction that) {
            return of(this.a * that.a, this.b * that.b);
        }

        Fraction divide(Fraction that) {
            return of(this.a * that.b, this.b * that.a);
        }

    }

    private static long gcd(long a, long b) {
        long c;
        while (b != 0) {
            c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    private static long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}
