package tcs_algo_acourse;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arr = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) arr.add(s);
        }
        arr.sort(MaxNumber::compare);
        for (String s : arr) System.out.print(s);
        System.out.println();
    }

    private static int compare(String a, String b) {
        int n1 = a.length(), n2 = b.length();
        if (n1 == n2) return b.compareTo(a);

        // cmp a+b and b+a
        int n = n1 + n2;
        for (int i = 0; i < n; i++) {
            char c1 = i < n1 ? a.charAt(i) : b.charAt(i - n1);
            char c2 = i < n2 ? b.charAt(i) : a.charAt(i - n2);
            if (c1 != c2) return c2 - c1;
        }
        return 0;
    }
}
