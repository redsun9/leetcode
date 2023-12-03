package advent.year2023.day3.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day3/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day3/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            List<EnginePart> previousRowEngineParts = new ArrayList<>();
            Set<Integer> previousRowSymbols = new HashSet<>();

            while (scanner.hasNextLine()) {
                List<EnginePart> currentRowEngineParts = new LinkedList<>();
                Set<Integer> currentRowSymbols = new HashSet<>();
                String s = scanner.nextLine().trim();
                int n = s.length();
                int pos = 0;
                while (pos < n) {
                    while (pos < n && s.charAt(pos) == '.') pos++;
                    while (pos < n && isSymbol(s.charAt(pos))) currentRowSymbols.add(pos++);
                    if (pos < n && isDigits(s.charAt(pos))) {
                        int start = pos;
                        long val = s.charAt(pos++) - '0';
                        while (pos < n && isDigits(s.charAt(pos))) val = val * 10 + s.charAt(pos++) - '0';
                        currentRowEngineParts.add(new EnginePart(val, start, pos - 1));
                    }
                }

                for (EnginePart enginePart : previousRowEngineParts) {
                    int start = enginePart.start;
                    int end = enginePart.end;
                    boolean hasNeighbour = false;
                    int check = start - 1;
                    while (!hasNeighbour && check <= end + 1) {
                        hasNeighbour |= previousRowSymbols.contains(check);
                        hasNeighbour |= currentRowSymbols.contains(check++);
                    }
                    if (hasNeighbour) ans += enginePart.val;
                }

                ListIterator<EnginePart> listIterator = currentRowEngineParts.listIterator();
                while (listIterator.hasNext()) {
                    EnginePart enginePart = listIterator.next();
                    int start = enginePart.start;
                    int end = enginePart.end;
                    boolean hasNeighbour = false;
                    int check = start - 1;
                    while (!hasNeighbour && check <= end + 1) {
                        hasNeighbour |= previousRowSymbols.contains(check);
                        hasNeighbour |= currentRowSymbols.contains(check++);
                    }
                    if (hasNeighbour) {
                        ans += enginePart.val;
                        listIterator.remove();
                    }
                }
                previousRowEngineParts = currentRowEngineParts;
                previousRowSymbols = currentRowSymbols;
            }
            printer.println(ans);
        }
    }

    private static boolean isDigits(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isSymbol(char c) {
        return c != '.' && !isDigits(c);
    }

    private record EnginePart(long val, int start, int end) {
    }
}
