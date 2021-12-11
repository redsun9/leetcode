package advent.day10.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int circle = 1;
    private static final int square = 2;
    private static final int figure = 3;
    private static final int angle = 4;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day10/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day10/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Long> scores = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int n = s.length();
                Stack<Character> stack = new Stack<>();
                boolean failed = false;
                for (int i = 0; i < n && !failed; i++) {
                    char c = s.charAt(i);
                    switch (c) {
                        case '{', '(', '[', '<' -> stack.push(c);
                        case ']' -> failed = stack.isEmpty() || stack.pop() != '[';
                        case '}' -> failed = stack.isEmpty() || stack.pop() != '{';
                        case ')' -> failed = stack.isEmpty() || stack.pop() != '(';
                        case '>' -> failed = stack.isEmpty() || stack.pop() != '<';
                    }
                }
                if (failed || stack.isEmpty()) continue;
                long score = 0;
                while (!stack.isEmpty()) {
                    score *= 5;
                    switch (stack.pop()) {
                        case '{' -> score += figure;
                        case '(' -> score += circle;
                        case '[' -> score += square;
                        case '<' -> score += angle;
                    }
                }
                scores.add(score);
            }
            Collections.sort(scores);
            printer.println(scores.get(scores.size() / 2));
        }
    }
}
