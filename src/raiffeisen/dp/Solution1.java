package raiffeisen.dp;

import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args) {
        HashMap<Integer, Double> map = new HashMap<>();
        double p = (1 - 0.33d) / 5;
        for (int i = 1; i <= 6; i++) {
            map.put(i, p);
        }
        map.put(4, 0.33);
        Solver solver = new Solver(x -> map);
        System.out.println(solver.probability(12, 8));
    }
}
