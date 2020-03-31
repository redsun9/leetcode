package leetcode.leetcode0xx.leetcode76;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) return "";
        Map<Character, LetterPositions> positionsMap = t.chars().mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, entry -> new LetterPositions(entry.getValue())));
        char[] sChars = s.toCharArray();
        final int n = sChars.length;
        SortedSet<LetterPositions> beginning = new TreeSet<>(Comparator.comparingInt(x -> x.positions.isEmpty() ? -1 : x.positions.getFirst()));
        SortedSet<LetterPositions> ending = new TreeSet<>(Comparator.comparingInt(x -> x.positions.isEmpty() ? n : x.positions.getLast()));

        int minFrom = 0, minTo = n;
        int minLength = Integer.MAX_VALUE;
        int toGetEnough = positionsMap.size();
        for (int i = 0; i < n; i++) {
            LetterPositions lp = positionsMap.get(sChars[i]);
            if (lp == null) continue;
            beginning.remove(lp);
            ending.remove(lp);
            lp.positions.addLast(i);
            if (lp.positions.size() == lp.toBeEnough) {
                toGetEnough--;
            }
            if (lp.positions.size() > lp.toBeEnough) {
                lp.positions.removeFirst();
            }
            beginning.add(lp);
            ending.add(lp);
            if (toGetEnough == 0) {
                Integer first = beginning.first().positions.getFirst();
                Integer last = ending.last().positions.getLast();
                int checkLength = last - first + 1;
                if (minLength > checkLength) {
                    minLength = checkLength;
                    minFrom = first;
                    minTo = last;
                }
            }
        }
        if (toGetEnough == 0) {
            return s.substring(minFrom, minTo + 1);
        } else {
            return "";
        }
    }

    private static class LetterPositions {
        private final int toBeEnough;
        private final LinkedList<Integer> positions = new LinkedList<>();

        private LetterPositions(long toBeEnough) {
            this.toBeEnough = (int) toBeEnough;
        }
    }
}
