package advent.day22.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    private static final String[][] files = {
            {"src/advent/day22/second/input.txt", "src/advent/day22/second/output.txt"},
            {"src/advent/day22/second/input2.txt", "src/advent/day22/second/output2.txt"}
    };

    public static void main(String[] args) throws IOException {
        for (String[] file : files) {
            try (
                    FileInputStream fis = new FileInputStream(file[0]);
                    Scanner scanner = new Scanner(fis);
                    FileOutputStream fos = new FileOutputStream(file[1]);
                    PrintStream printer = new PrintStream(fos)
            ) {
                List<int[]> queries = readInput(scanner);
                long start = System.currentTimeMillis();
                long ans1 = Solver1.solve(queries);
                long end = System.currentTimeMillis();
                System.out.println(end - start);

                start = System.currentTimeMillis();
                long ans2 = Solver1.solve(queries);
                end = System.currentTimeMillis();
                System.out.println(end - start);

                start = System.currentTimeMillis();
                long ans3 = Solver3.solve(queries);
                end = System.currentTimeMillis();
                System.out.println(end - start);

                assertEquals(ans1, ans2);
                assertEquals(ans2, ans3);
                printer.println(ans2);
            }
        }
    }


    private static List<int[]> readInput(Scanner scanner) {
        List<int[]> requests = new ArrayList<>();
        int posStart, posMid, posEnd;
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();

            posStart = s.indexOf('=');
            posMid = s.indexOf("..", posStart);
            posEnd = s.indexOf(',', posMid);

            int startX = Integer.parseInt(s, posStart + 1, posMid, 10);
            int endX = Integer.parseInt(s, posMid + 2, posEnd, 10);

            posStart = s.indexOf('=', posEnd);
            posMid = s.indexOf("..", posStart);
            posEnd = s.indexOf(',', posMid);

            int startY = Integer.parseInt(s, posStart + 1, posMid, 10);
            int endY = Integer.parseInt(s, posMid + 2, posEnd, 10);

            posStart = s.indexOf('=', posEnd);
            posMid = s.indexOf("..", posStart);
            posEnd = s.length();

            int startZ = Integer.parseInt(s, posStart + 1, posMid, 10);
            int endZ = Integer.parseInt(s, posMid + 2, posEnd, 10);

            int val = s.charAt(1) == 'n' ? 1 : 0;

            requests.add(new int[]{startX, endX + 1, startY, endY + 1, startZ, endZ + 1, val});
        }
        return requests;
    }
}
