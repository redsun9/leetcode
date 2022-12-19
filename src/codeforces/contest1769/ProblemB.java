package codeforces.contest1769;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("DuplicatedCode")
public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream printer = new PrintStream(System.out);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextLong();
        List<Integer> percents = getCommonPercents(arr);
        for (Integer percent : percents) {
            printer.println(percent);
        }
    }

    public static List<Integer> getCommonPercents(long[] arr) {
        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        long total = 0;
        for (long a : arr) total += a;

        long s = 0;
        for (long a : arr) {
            int lo = (int) (s * 100 / total), hi = (int) ((s + a) * 100 / total);
            for (int p = lo; p <= hi; p++) {
                if (ans.get(ans.size() - 1) == p) continue;
                long x1 = (a * p + 99) / 100, x2 = Math.min(a - 1, ((p + 1) * a - 1) / 100);
                long x3 = (p * total + 99) / 100 - s, x4 = Math.min(((p + 1) * total - 1) / 100 - s, a - 1);
                if (x1 <= x2 && x3 <= x4 && x2 >= x3 && x4 >= x1) ans.add(p);
            }
            s += a;
        }
        ans.add(100);
        return ans;
    }
}



