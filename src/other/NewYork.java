package other;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class NewYork {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        for (int k = 0; k < t; k++) {
            int n = Integer.parseInt(scanner.nextLine());
            int[][] coords = new int[n][2];
            for (int i = 0; i < n; i++) {
                coords[i][0] = scanner.nextInt();
                coords[i][1] = scanner.nextInt();
            }
            HashMap<Pair, Integer> countMap = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (coords[i][1] == coords[j][1]) {
                        Pair pair = new Pair(coords[i][0], coords[j][0]);
                        ans += countMap.getOrDefault(pair, 0);
                        countMap.put(pair, countMap.getOrDefault(pair, 0) + 1);
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static final class Pair {
        int x1, x2;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x1 == pair.x1 &&
                    x2 == pair.x2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, x2);
        }

        public Pair(int x1, int x2) {
            this.x1 = x1;
            this.x2 = x2;
        }
    }
}
