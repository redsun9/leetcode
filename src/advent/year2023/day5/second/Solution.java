package advent.year2023.day5.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.isDigit;
import static java.lang.Long.MAX_VALUE;
import static java.lang.Long.parseLong;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final Mapping DEFAULT = new Mapping(0, MAX_VALUE, 0);

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day5/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day5/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Range> previousSet = new ArrayList<>();
            String[] initial = scanner.nextLine().trim().split(": ")[1].split(" ");
            for (int i = 0; i < initial.length; i += 2) {
                long start = parseLong(initial[i]);
                long length = parseLong(initial[i + 1]);
                previousSet.add(new Range(start, start + length));
            }
            List<Mapping> mapping = new ArrayList<>();
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                if ((s.isBlank() || !isDigit(s.charAt(0)))) {
                    if (!mapping.isEmpty()) { //1421233717
                        previousSet = processMapping(previousSet, mapping);
                        mapping.clear();
                    }
                } else {
                    String[] split = s.split(" ");
                    long fromStart = parseLong(split[1]);
                    long toStart = parseLong(split[0]);
                    long length = parseLong(split[2]);
                    mapping.add(new Mapping(fromStart, fromStart + length, toStart - fromStart));
                }
            }
            if (!mapping.isEmpty()) previousSet = processMapping(previousSet, mapping);
            long ans = MAX_VALUE;
            for (Range val : previousSet) ans = Math.min(ans, val.start);
            printer.println(ans);
        }
    }

    private static List<Range> processMapping(List<Range> previousSet, List<Mapping> mappings) {
        previousSet.sort(Comparator.comparingLong(x -> x.start));
        mappings.sort(Comparator.comparingLong(x -> x.fromStart));
        int i = 0, j = 0, m = previousSet.size(), n = mappings.size();
        long current = 0;
        List<Range> result = new ArrayList<>();
        while (i < m) {
            Range range = previousSet.get(i);
            Mapping mapping = j < n ? mappings.get(j) : DEFAULT;

            long rangeStart = Math.max(range.start, current);

            if (mapping.fromEnd <= rangeStart) j++; // range is less
            else if (range.end <= mapping.fromStart) { //range is right
                result.add(new Range(rangeStart, range.end));
                i++;
            } else { //intersection
                long left = Math.max(rangeStart, mapping.fromStart);
                long right = Math.min(range.end, mapping.fromEnd);
                if (rangeStart < left) result.add(new Range(rangeStart, left));
                result.add(new Range(left + mapping.diff, right + mapping.diff));
                current = right;
                if (current == range.end) i++;
            }
        }
        result.sort(Comparator.comparingLong(Range::start).thenComparingLong(Range::end));

        List<Range> compressed = new ArrayList<>();
        for (Range range : result) {
            if (!compressed.isEmpty() && compressed.get(compressed.size() - 1).end == range.start) {
                compressed.add(new Range(compressed.remove(compressed.size() - 1).start, range.end));
            } else compressed.add(range);
        }
        return compressed;
    }

    private record Range(long start, long end) {
    }

    private record Mapping(long fromStart, long fromEnd, long diff) {
    }
}