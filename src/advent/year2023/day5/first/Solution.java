package advent.year2023.day5.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

import static java.lang.Character.isDigit;
import static java.lang.Long.parseLong;

public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day5/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day5/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Set<Long> previousSet = new HashSet<>();
            for (String part : scanner.nextLine().trim().split(": ")[1].split(" ")) {
                previousSet.add(parseLong(part));
            }
            TreeMap<Long, Pair> mapping = new TreeMap<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if ((s.isBlank() || !isDigit(s.charAt(0)))) {
                    if (!mapping.isEmpty()) {
                        Set<Long> nextSet = new HashSet<>();
                        for (Long prev : previousSet) {
                            Map.Entry<Long, Pair> floorEntry = mapping.floorEntry(prev);
                            if (floorEntry != null && floorEntry.getKey() + floorEntry.getValue().length > prev) {
                                nextSet.add(prev - floorEntry.getKey() + floorEntry.getValue().to);
                            } else nextSet.add(prev);
                        }
                        previousSet = nextSet;
                        mapping.clear();
                    }
                } else {
                    String[] split = s.split(" ");
                    mapping.put(parseLong(split[1]), new Pair(parseLong(split[0]), parseLong(split[2])));
                }
            }
            long ans = Long.MAX_VALUE;
            for (long val : previousSet) ans = Math.min(ans, val);
            printer.println(ans);
        }
    }

    private record Pair(long to, long length) {
    }
}
