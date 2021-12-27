package tinkoff.advent17;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent17/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent17/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Stack<Character> stack = new Stack<>();
            String s = scanner.nextLine();
            int n = s.length(), ans = 0;
            for (int i = 0; i < n; i++) {
                switch (s.charAt(i)) {
                    case '(' -> stack.push('(');
                    case '{' -> stack.push('{');
                    case '[' -> stack.push('[');
                    case ')', ']' -> stack.pop();
                    case '}' -> {
                        stack.pop();
                        if (stack.isEmpty()) ans++;
                    }
                }
            }
            printer.println(ans);
        }
    }
}
