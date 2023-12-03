package advent.year2023.day3.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day3/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day3/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<EnginePart> numbers = new ArrayList<>();
            Map<Pair, List<Long>> gears = new HashMap<>();

            int row = 0;
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int n = s.length();
                int pos = 0;
                while (pos < n) {
                    while (pos < n && toIgnore(s.charAt(pos))) pos++;
                    while (pos < n && s.charAt(pos) == '*') gears.put(new Pair(row, pos++), new ArrayList<>());
                    if (pos < n && isDigits(s.charAt(pos))) {
                        int start = pos;
                        long val = s.charAt(pos++) - '0';
                        while (pos < n && isDigits(s.charAt(pos))) val = val * 10 + s.charAt(pos++) - '0';
                        numbers.add(new EnginePart(val, row, start, pos - 1));
                    }
                }
                row++;
            }
            for (EnginePart enginePart : numbers) {
                int i1 = enginePart.row - 1, i2 = enginePart.row + 1, j1 = enginePart.start - 1, j2 = enginePart.end + 1;
                for (int i = i1; i <= i2; i++) {
                    for (int j = j1; j <= j2; j++) {
                        Pair key = new Pair(i, j);
                        List<Long> list = gears.get(key);
                        if (list != null) {
                            list.add(enginePart.val);
                            if (list.size() >= 3) gears.remove(key);
                        }
                    }
                }
            }

            long ans = 0;
            for (List<Long> list : gears.values()) if (list.size() == 2) ans += list.get(0) * list.get(1);
            printer.println(ans);
        }
    }

    private static boolean isDigits(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean toIgnore(char c) {
        return c != '*' && !isDigits(c);
    }

    private record EnginePart(long val, int row, int start, int end) {
    }

    private record Pair(int row, int col) {
    }
}