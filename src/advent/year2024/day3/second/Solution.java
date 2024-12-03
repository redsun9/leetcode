package advent.year2024.day3.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2024/day3/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2024/day3/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            long ans = 0;
            Pattern pattern = Pattern.compile("mul\\(\\d{1,3},\\d{1,3}\\)");
            Pattern patternDo = Pattern.compile("do\\(\\)");
            Pattern patternDont = Pattern.compile("don't\\(\\)");

            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();

                Matcher matcherDo = patternDo.matcher(s);
                List<Integer> doPositions = new ArrayList<>();
                doPositions.add(-1);
                while (matcherDo.find()) doPositions.add(matcherDo.start());

                Matcher matcherDont = patternDont.matcher(s);
                List<Integer> dontPositions = new ArrayList<>();
                dontPositions.add(-2);
                while (matcherDont.find()) dontPositions.add(matcherDont.start());

                Matcher matcher = pattern.matcher(s);
                int i1 = 0, i2 = 0;
                while (matcher.find()) {
                    int start = matcher.start();
                    while (i1 < doPositions.size() && doPositions.get(i1) < start) i1++;
                    while (i2 < dontPositions.size() && dontPositions.get(i2) < start) i2++;

                    if (doPositions.get(i1 - 1) < dontPositions.get(i2 - 1)) continue;
                    String group = matcher.group();
                    int pos = group.indexOf(",");
                    ans += (long) parseInt(group, 4, pos, 10) * parseInt(group, pos + 1, group.length() - 1, 10);
                }
            }
            printer.println(ans);
        }
    }
}
