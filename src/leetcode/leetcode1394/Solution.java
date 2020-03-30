package leetcode.leetcode1394;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public int findLucky(int[] arr) {
        return Arrays.stream(arr).boxed().
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue().intValue() == e.getKey())
                .map(Map.Entry::getKey).max(Comparator.comparingInt(x -> x)).orElse(-1);
    }
}
