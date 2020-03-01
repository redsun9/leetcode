package atcoder.abc157;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class ProblemB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] a = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
        Collection<Collection<Integer>> lines = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            row.add(a[i][0]);
            row.add(a[i][1]);
            row.add(a[i][2]);
            lines.add(row);
            ArrayList<Integer> col = new ArrayList<>();
            col.add(a[0][i]);
            col.add(a[1][i]);
            col.add(a[2][i]);
            lines.add(col);
        }
        ArrayList<Integer> diag1 = new ArrayList<>();
        diag1.add(a[0][0]);
        diag1.add(a[1][1]);
        diag1.add(a[2][2]);
        lines.add(diag1);
        ArrayList<Integer> diag2 = new ArrayList<>();
        diag2.add(a[2][0]);
        diag2.add(a[1][1]);
        diag2.add(a[0][2]);
        lines.add(diag2);

        boolean[][] b = new boolean[3][3];
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int c = scanner.nextInt();
            for (Collection<Integer> line : lines) {
                line.remove(c);
                if (line.isEmpty()) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }
}
