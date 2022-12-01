package advent.year2021.day10.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int circle = 3;
    private static final int square = 57;
    private static final int figure = 1197;
    private static final int angle = 25137;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day10/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day10/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int ans = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int n = s.length();
                Stack<Character> stack = new Stack<>();
                boolean failed = false;
                for (int i = 0; i < n && !failed; i++) {
                    char c = s.charAt(i);
                    switch (c) {
                        case '{', '(', '[', '<' -> stack.push(c);
                        case ']' -> {
                            failed = stack.isEmpty() || stack.pop() != '[';
                            if (failed) ans += square;
                        }
                        case '}' -> {
                            failed = stack.isEmpty() || stack.pop() != '{';
                            if (failed) ans += figure;
                        }
                        case ')' -> {
                            failed = stack.isEmpty() || stack.pop() != '(';
                            if (failed) ans += circle;
                        }
                        case '>' -> {
                            failed = stack.isEmpty() || stack.pop() != '<';
                            if (failed) ans += angle;
                        }
                    }
                }
            }
            printer.println(ans);
        }
    }
}
