package atcoder.abc154;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (!set.add(scanner.nextInt())) {
                System.out.println("NO");
                return;
            }
            ;
        }
        System.out.println("YES");
    }
}
