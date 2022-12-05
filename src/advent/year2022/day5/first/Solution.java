package advent.year2022.day5.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Integer.parseInt;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day5/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day5/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Deque<Character>> stacks = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                int pos = s.indexOf('[');
                if (pos == -1) break;
                while (pos != -1) {
                    int idx = pos / 4;
                    char label = s.charAt(pos + 1);
                    while (stacks.size() <= idx) stacks.add(new ArrayDeque<>());
                    stacks.get(idx).addFirst(label);
                    pos = s.indexOf('[', pos + 1);
                }
            }
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                String[] parts = s.split(" ");
                int num = parseInt(parts[1]), from = parseInt(parts[3]), to = parseInt(parts[5]);
                Deque<Character> stackFrom = stacks.get(from - 1);
                Deque<Character> stackTo = stacks.get(to - 1);
                while (num-- != 0) stackTo.addLast(stackFrom.removeLast());
            }
            for (Deque<Character> stack : stacks) printer.print(stack.peekLast());
        }
    }
}
