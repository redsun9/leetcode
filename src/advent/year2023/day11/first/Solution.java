package advent.year2023.day11.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day11/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day11/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());
            printer.println(solve(list));
        }
    }

    private static long solve(List<String> list) {
        List<Integer> pointRawRows = new ArrayList<>();
        List<Integer> pointRawCols = new ArrayList<>();

        int m = list.size();
        int n = list.get(0).length();
        for (int i = 0; i < m; i++) {
            String s = list.get(i);
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '#') {
                    pointRawRows.add(i);
                    pointRawCols.add(j);
                }
            }
        }
        return processCoordinate(pointRawRows) + processCoordinate(pointRawCols);
    }

    private static long processCoordinate(List<Integer> points) {
        Collections.sort(points);
        long ans = 0;
        long prev = points.get(0), curr;
        long sumToPrevious = 0;
        for (int i = 1; i < points.size(); i++) {
            curr = points.get(i);
            if (curr - prev >= 2) sumToPrevious += i * ((curr - prev - 1) * 2 + 1);
            else sumToPrevious += i * (curr - prev);
            ans += sumToPrevious;
            prev = curr;
        }
        return ans;
    }
}
