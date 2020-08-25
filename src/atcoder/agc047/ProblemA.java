package atcoder.agc047;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class ProblemA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<Pair, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long d = Math.round(Double.parseDouble(scanner.nextLine()) * 1e9);
            int two = 0, five = 0;
            while (d % 2 == 0) {
                two++;
                d /= 2;
            }
            while (d % 5 == 0) {
                five++;
                d /= 5;
            }
            Pair pair = new Pair(two, five);
            map.compute(pair, (key, val) -> val == null ? 1 : val + 1);
        }
        long ans = 0;
        for (Map.Entry<Pair, Integer> p1 : map.entrySet()) {
            for (Map.Entry<Pair, Integer> p2 : map.entrySet()) {
                if (p1.getKey().two + p2.getKey().two >= 18 && p1.getKey().five + p2.getKey().five >= 18) {
                    if (p1 == p2) ans += (long) p1.getValue() * (p1.getValue() - 1);
                    else ans += (long) p1.getValue() * p2.getValue();
                }
            }
        }
        System.out.println(ans / 2);
    }

    private static class Pair {
        private final int two, five;

        private Pair(int two, int five) {
            this.two = two;
            this.five = five;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return two == pair.two &&
                    five == pair.five;
        }

        @Override
        public int hashCode() {
            return Objects.hash(two, five);
        }
    }
}
