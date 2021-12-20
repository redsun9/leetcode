package tinkoff.advent10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings("DuplicatedCode")
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/tinkoff/advent10/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/tinkoff/advent10/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            int n = Integer.parseInt(scanner.nextLine());
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

            int ans = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < n; i++) {
                while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                    Integer pop = stack.pop();
                    ans = Math.max(ans, (i - (stack.isEmpty() ? 0 : stack.peek() + 1)) * arr[pop]);
                }
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                Integer pop = stack.pop();
                ans = Math.max(ans, (n - (stack.isEmpty() ? 0 : stack.peek() + 1)) * arr[pop]);
            }
            printer.println(ans);
        }
    }
}
