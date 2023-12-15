package advent.year2023.day15.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static final int MOD = 256;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2023/day15/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2023/day15/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            String input = scanner.nextLine().trim();
            printer.println(solve(input));
        }
    }


    private static int solve(String input) {
        LinkedHashMap<String, Integer>[] boxes = new LinkedHashMap[MOD];
        for (int i = 0; i < MOD; i++) boxes[i] = new LinkedHashMap<>();

        for (String s : input.split(",")) {
            int pos = s.indexOf('=');
            if (pos > 0) {
                String label = s.substring(0, pos);
                int val = Integer.parseInt(s.substring(pos + 1));
                boxes[hash(label)].put(label, val);
            } else {
                String label = s.substring(0, s.length() - 1);
                boxes[hash(label)].remove(label);
            }
        }

        int ans = 0;
        for (int boxNumber = 1; boxNumber <= MOD; boxNumber++) {
            LinkedHashMap<String, Integer> box = boxes[boxNumber - 1];
            int slotNumber = 1;
            for (Map.Entry<String, Integer> entry : box.entrySet()) {
                ans += boxNumber * slotNumber * entry.getValue();
                slotNumber++;
            }
        }
        return ans;
    }

    private static int hash(String label) {
        int ans = 0, n = label.length();
        for (int i = 0; i < n; i++) ans = (ans + label.charAt(i)) * 17 % MOD;
        return ans;
    }
}