package leetcode.leetcode2xx.leetcode288;

import java.util.HashMap;
import java.util.Objects;

public class ValidWordAbbr {
    private final HashMap<Abbreviation, String> set = new HashMap<>();
    private final HashMap<Abbreviation, Integer> count = new HashMap<>();

    public ValidWordAbbr(String[] dictionary) {
        for (String word : dictionary) {
            Abbreviation key = new Abbreviation(word);
            set.put(key, word);
            count.compute(key, (k, v) -> v == null ? 1 : v + 1);
        }
    }


    public boolean isUnique(String word) {
        Abbreviation key = new Abbreviation(word);
        return set.getOrDefault(key, word).equals(word) && count.getOrDefault(key, 0) <= 1;
    }

    private static class Abbreviation {
        private final char start, end;
        private final int n;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Abbreviation that = (Abbreviation) o;
            return start == that.start && end == that.end && n == that.n;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end, n);
        }

        public Abbreviation(String word) {
            this.n = word.length();
            this.start = n == 0 ? ' ' : word.charAt(0);
            this.end = n == 0 ? ' ' : word.charAt(n - 1);
        }
    }
}
