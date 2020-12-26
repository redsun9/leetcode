package leetcode.leetcode16xx.leetcode1657;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    private static Map<Long, Long> countMap(String word) {
        return word.chars().boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    private static Set<Integer> countSet(String word) {
        return word.chars().boxed().collect(Collectors.toSet());
    }

    public boolean closeStrings(String word1, String word2) {
        return word1.length() == word2.length() &&
                countSet(word1).equals(countSet(word2)) &&
                countMap(word1).equals(countMap(word2));
    }
}
