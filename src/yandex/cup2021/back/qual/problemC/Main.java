package yandex.cup2021.back.qual.problemC;

import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

@SuppressWarnings("DuplicatedCode")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        Set<Pair> all = new HashSet<>();

        int w = scanner.nextInt();
        Set<Pair> white = new HashSet<>();
        for (int i = 0; i < w; i++) {
            Pair pair = new Pair(scanner.nextInt() - 1, scanner.nextInt() - 1);
            white.add(pair);
            all.add(pair);
        }

        int b = scanner.nextInt();
        Set<Pair> black = new HashSet<>();
        for (int i = 0; i < b; i++) {
            Pair pair = new Pair(scanner.nextInt() - 1, scanner.nextInt() - 1);
            black.add(pair);
            all.add(pair);
        }

        scanner.nextLine();
        boolean move = scanner.nextLine().strip().charAt(0) == 'b';
        boolean ans = move ? check(n, m, black, white, all) : check(n, m, white, black, all);
        System.out.println(ans ? "Yes" : "No");
    }


    private static boolean check(int n, int m, Set<Pair> black, Set<Pair> white, Set<Pair> all) {
        for (Pair b : black) {
            int i1 = b.x, j1 = b.y;
            for (int i2 = i1 - 1, i3 = i1 - 2; i2 <= i1 + 1; i2 += 2, i3 += 4) {
                if (i3 < 0 || i3 >= n) continue;
                for (int j2 = j1 - 1, j3 = j1 - 2; j2 <= j1 + 1; j2 += 2, j3 += 4) {
                    if (j3 < 0 || j3 >= m) continue;
                    if (white.contains(new Pair(i2, j2)) && !all.contains(new Pair(i3, j3))) return true;
                }
            }
        }
        return false;
    }

    private static class Pair {
        final int x, y;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
