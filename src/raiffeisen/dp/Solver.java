package raiffeisen.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class Solver {

    private final Function<Integer, Map<Integer, Double>> fProb;
    private final HashMap<Pair, Double> cache = new HashMap<>();
    private final HashMap<Integer, Map<Integer, Double>> fProbCache = new HashMap<>();

    public Solver(
            Function<Integer, Map<Integer, Double>> fProb
    ) {
        this.fProb = fProb;
    }

    public double probability(int firstDist, int secondDist) {
        if (firstDist <= 0) return 1;
        if (secondDist <= 0) return 0;
        Pair pair = new Pair(firstDist, secondDist);
        Pair reversePair = new Pair(secondDist, firstDist);
        if (cache.containsKey(pair)) return cache.get(pair);

        Map<Integer, Double> curMoves = getMoves(firstDist);
        double p1 = 1.0;
        for (Map.Entry<Integer, Double> entry : curMoves.entrySet()) {
            if (entry.getKey() > firstDist || entry.getKey() == 0) p1 -= entry.getValue();
        }

        Map<Integer, Double> nextMoves = getMoves(secondDist);
        double p2 = 1.0;
        for (Map.Entry<Integer, Double> entry : nextMoves.entrySet()) {
            if (entry.getKey() > secondDist || entry.getKey() == 0) p2 -= entry.getValue();
        }

        double coeff1 = p1 / (p1 + p2 - p1 * p2);
        double coeff2 = p2 / (p1 + p2 - p1 * p2);

        double ans11 = 0, ans12 = 0;
        for (Map.Entry<Integer, Double> entry : curMoves.entrySet()) {
            if (entry.getKey() > firstDist || entry.getKey() == 0) continue;
            ans11 += entry.getValue() * (1 - probability(secondDist, firstDist - entry.getKey()));
            ans12 += entry.getValue() * probability(secondDist, firstDist - entry.getKey());
        }

        double ans21 = 0, ans22 = 0;
        for (Map.Entry<Integer, Double> entry : nextMoves.entrySet()) {
            if (entry.getKey() > secondDist || entry.getKey() == 0) continue;
            ans21 += entry.getValue() * (probability(firstDist, secondDist - entry.getKey()));
            ans22 += entry.getValue() * (1 - probability(firstDist, secondDist - entry.getKey()));
        }

        double ansFirst = ans11 / p1 * coeff1 + ans21 / p2 * (1 - coeff1);
        double ansSecond = ans12 / p1 * (1 - coeff2) + ans22 / p2 * coeff2;
        cache.put(pair, ansFirst);
        cache.put(reversePair, ansSecond);
        return ansFirst;
    }

    private Map<Integer, Double> getMoves(int x) {
        if (fProbCache.containsKey(x)) return fProbCache.get(x);
        Map<Integer, Double> map = fProb.apply(x);
        fProbCache.put(x, map);
        return map;
    }


    private static class Pair {
        int a, b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return a == pair.a &&
                    b == pair.b;
        }

        @Override
        public int hashCode() {
            return Objects.hash(a, b);
        }
    }
}
