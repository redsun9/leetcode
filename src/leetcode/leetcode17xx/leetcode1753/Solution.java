package leetcode.leetcode17xx.leetcode1753;

import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public int maximumScore(int a, int b, int c) {
        List<Integer> list = List.of(a, b, c).stream().sorted().collect(Collectors.toList());
        a = list.get(2);
        b = list.get(1);
        if (a == 0) return b;
        c = list.get(0);
        if (a <= b + c) return (a + b + c) / 2;
        else return b + c;
    }
}
