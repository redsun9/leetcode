package advent.year2023.day19.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final String accept = "A";
    private static final String reject = "R";
    private static final String start = "in";
    private static final int MIN_VAL = 1;
    private static final int MAX_VAL = 4000;


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day19/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day19/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static List<Process> parseInput(Scanner scanner) {
        List<Process> processes = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) processes.add(parseProcess(s));
            else break;
        }
        return processes;
    }

    private static Process parseProcess(String s) {
        int index = s.indexOf('{');
        String name = s.substring(0, index);
        String[] split = s.substring(index + 1, s.length() - 1).split(",");
        List<ProcessPart> parts = new ArrayList<>(split.length);
        for (int i = 0; i < split.length - 1; i++) {
            String string = split[i];
            parts.add(parseProcessPart(string));
        }
        parts.add(new ProcessPart(DetailRange.DEFAULT, split[split.length - 1]));
        return new Process(name, parts);
    }

    private static ProcessPart parseProcessPart(String s) {
        int index1 = s.indexOf('<');
        if (index1 < 0) index1 = s.indexOf('>');
        int index2 = s.indexOf(':');

        int threshold = parseInt(s, index1 + 1, index2, 10);
        boolean less = s.charAt(index1) == '<';

        DetailRange range = DetailRange.DEFAULT;
        int x1 = range.x1, x2 = range.x2, m1 = range.m1, m2 = range.m2, a1 = range.a1, a2 = range.a2, s1 = range.s1, s2 = range.s2;

        switch (s.substring(0, index1)) {
            case "x" -> {
                if (less) x2 = threshold - 1;
                else x1 = threshold + 1;
            }
            case "m" -> {
                if (less) m2 = threshold - 1;
                else m1 = threshold + 1;
            }
            case "a" -> {
                if (less) a2 = threshold - 1;
                else a1 = threshold + 1;
            }
            case "s" -> {
                if (less) s2 = threshold - 1;
                else s1 = threshold + 1;
            }
            default -> throw new RuntimeException();
        }
        DetailRange detailRange = new DetailRange(x1, x2, m1, m2, a1, a2, s1, s2);

        return new ProcessPart(detailRange, s.substring(index2 + 1));
    }

    private static long solve(List<Process> processes) {
        Map<String, Process> processMap = processes.stream().collect(Collectors.toMap(
                Process::name,
                Function.identity()
        ));
        return solve(processMap, DetailRange.DEFAULT, start);
    }

    private static long solve(Map<String, Process> processMap, DetailRange detailRange, String processName) {
        if (processName.equals(accept)) return volume(detailRange);
        if (processName.equals(reject)) return 0L;

        Process process = processMap.get(processName);
        long ans = 0L;
        for (ProcessPart part : process.parts) {
            DetailRange intersection = intersect(detailRange, part.condition);
            if (intersection != null) ans += solve(processMap, intersection, part.target);
            else continue;
            detailRange = substract(detailRange, part.condition);
            if (detailRange == null) break;
        }
        return ans;
    }

    private static long volume(DetailRange range) {
        return (range.x2 - range.x1 + 1L) *
                (range.m2 - range.m1 + 1L) *
                (range.a2 - range.a1 + 1L) *
                (range.s2 - range.s1 + 1L);
    }

    private static DetailRange intersect(DetailRange range, DetailRange condition) {
        if (condition == DetailRange.DEFAULT) return range;
        int x1 = Math.max(range.x1, condition.x1);
        int x2 = Math.min(range.x2, condition.x2);
        int m1 = Math.max(range.m1, condition.m1);
        int m2 = Math.min(range.m2, condition.m2);
        int a1 = Math.max(range.a1, condition.a1);
        int a2 = Math.min(range.a2, condition.a2);
        int s1 = Math.max(range.s1, condition.s1);
        int s2 = Math.min(range.s2, condition.s2);
        if (x1 > x2 || m1 > m2 || a1 > a2 || s1 > s2) return null;
        return new DetailRange(x1, x2, m1, m2, a1, a2, s1, s2);
    }

    private static DetailRange substract(DetailRange range, DetailRange condition) {
        if (condition == DetailRange.DEFAULT) return null;
        int x1 = range.x1, x2 = range.x2, m1 = range.m1, m2 = range.m2, a1 = range.a1, a2 = range.a2, s1 = range.s1, s2 = range.s2;
        if (condition.x1 != MIN_VAL) x2 = Math.min(x2, condition.x1 - 1);
        if (condition.x2 != MAX_VAL) x1 = Math.max(x1, condition.x2 + 1);
        if (condition.m1 != MIN_VAL) m2 = Math.min(m2, condition.m1 - 1);
        if (condition.m2 != MAX_VAL) m1 = Math.max(m1, condition.m2 + 1);
        if (condition.a1 != MIN_VAL) a2 = Math.min(a2, condition.a1 - 1);
        if (condition.a2 != MAX_VAL) a1 = Math.max(a1, condition.a2 + 1);
        if (condition.s1 != MIN_VAL) s2 = Math.min(s2, condition.s1 - 1);
        if (condition.s2 != MAX_VAL) s1 = Math.max(s1, condition.s2 + 1);
        if (x1 > x2 || m1 > m2 || a1 > a2 || s1 > s2) return null;
        return new DetailRange(x1, x2, m1, m2, a1, a2, s1, s2);
    }


    private record DetailRange(int x1, int x2, int m1, int m2, int a1, int a2, int s1, int s2) {
        static DetailRange DEFAULT = new DetailRange(MIN_VAL, MAX_VAL, MIN_VAL, MAX_VAL, MIN_VAL, MAX_VAL, MIN_VAL, MAX_VAL);
    }

    private record Process(String name, List<ProcessPart> parts) {
    }

    private record ProcessPart(DetailRange condition, String target) {
    }
}
