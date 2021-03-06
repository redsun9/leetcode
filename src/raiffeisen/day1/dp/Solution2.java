package raiffeisen.day1.dp;

import java.util.HashMap;

public class Solution2 {
    public static void main(String[] args) {
        for (int i = 1; i <= 11; i++) {
            int accPos = i;
            Solver solver = new Solver(x -> {
                HashMap<Integer, Double> map = new HashMap<>();
                double p = 1.0 / 6;
                for (int j = 1; j <= 6; j++) map.put(j, p);
                if (x - accPos >= 1 && x - accPos <= 6) map.put(x - accPos + 6, map.remove(x - accPos));
                return map;
            });
            System.out.println(i + " " + solver.probability(12, 8));
        }
    }
}
