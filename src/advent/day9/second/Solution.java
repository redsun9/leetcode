package advent.day9.second;

import basic.UnionFind;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.*;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day9/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day9/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<String> list = new ArrayList<>();
            while (scanner.hasNextLine()) list.add(scanner.nextLine().trim());

            int m = list.size(), n = list.get(0).length(), ans = 0;
            UnionFind uf = new UnionFind(m * n);

            for (int i = 0; i < m; i++) {
                String s = list.get(i);
                String prev = i != 0 ? list.get(i - 1) : null;
                for (int j = 0; j < n; j++) {
                    char c = s.charAt(j);
                    if (c == '9') continue;

                    if (j != 0 && s.charAt(j - 1) != '9') uf.union(i * n + j, i * n + j - 1);
                    if (prev != null && prev.charAt(j) != '9') uf.union(i * n + j, i * n + j - n);
                }
            }

            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0, idx = 0; i < m; i++) {
                String s = list.get(i);
                for (int j = 0; j < n; j++, idx++) {
                    if (s.charAt(j) != '9') countMap.compute(uf.find(idx), (k, v) -> v == null ? 1 : v + 1);
                }
            }

            int max1 = 0, max2 = 0, max3 = 0;
            for (Integer value : countMap.values()) {
                if (value > max3) {
                    if (value > max2) {
                        if (value > max1) {
                            max3 = max2;
                            max2 = max1;
                            max1 = value;
                        } else {
                            max3 = max2;
                            max2 = value;
                        }
                    } else {
                        max3 = value;
                    }
                }
            }
            printer.println(max1 * max2 * max3);
        }
    }
}
