package advent.year2023.day19.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Solution {
    private static final String accept = "A";
    private static final String reject = "R";
    private static final String start = "in";


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day19/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day19/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            printer.println(solve(parseInput(scanner)));
        }
    }

    private static Pair<List<Process>, List<Detail>> parseInput(Scanner scanner) {
        List<Process> processes = new ArrayList<>();
        List<Detail> details = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) processes.add(parseProcess(s));
            else break;
        }

        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isBlank()) details.add(parseDetail(s));
            else break;
        }

        return new Pair<>(processes, details);
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
        parts.add(new ProcessPart(x -> true, split[split.length - 1]));
        return new Process(name, parts);
    }

    private static ProcessPart parseProcessPart(String s) {
        int index1 = s.indexOf('<');
        if (index1 < 0) index1 = s.indexOf('>');
        int index2 = s.indexOf(':');

        ToIntFunction<Detail> getter = switch (s.substring(0, index1)) {
            case "a" -> Detail::a;
            case "x" -> Detail::x;
            case "m" -> Detail::m;
            case "s" -> Detail::s;
            default -> throw new RuntimeException();
        };

        int threshold = parseInt(s, index1 + 1, index2, 10);

        Predicate<Detail> condition;
        if (s.charAt(index1) == '<') condition = x -> getter.applyAsInt(x) < threshold;
        else condition = x -> getter.applyAsInt(x) > threshold;

        return new ProcessPart(condition, s.substring(index2 + 1));
    }

    private static Detail parseDetail(String s) {
        String[] split = s.substring(1, s.length() - 1).split(",");
        return new Detail(
                parseInt(split[0], 2, split[0].length(), 10),
                parseInt(split[1], 2, split[1].length(), 10),
                parseInt(split[2], 2, split[2].length(), 10),
                parseInt(split[3], 2, split[3].length(), 10)
        );
    }

    private static int solve(Pair<List<Process>, List<Detail>> input) {
        Map<String, Process> processMap = input.first.stream().collect(Collectors.toMap(
                Process::name,
                Function.identity()
        ));

        return input.second.stream()
                .filter(x -> processDetail(processMap, x))
                .mapToInt(x -> x.a + x.s + x.m + x.x)
                .sum();
    }

    private static boolean processDetail(Map<String, Process> processMap, Detail detail) {
        String node = start;
        while (!node.equals(reject) && !node.equals(accept)) {
            Process process = processMap.get(node);
            for (ProcessPart part : process.parts) {
                if (part.condition.test(detail)) {
                    node = part.target;
                    break;
                }
            }
        }
        return node.equals(accept);
    }


    private record Detail(int x, int m, int a, int s) {
    }

    private record Process(String name, List<ProcessPart> parts) {
    }

    private record ProcessPart(Predicate<Detail> condition, String target) {
    }

    private record Pair<A, B>(A first, B second) {
    }
}
