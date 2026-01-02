package leetcode.leetcode37xx.leetcode3765;

import java.util.Set;

public class Solution {
    private static final Set<Integer> completePrimes = Set.of(2, 3, 5, 7, 23, 37, 53, 73, 313, 317, 373, 797, 3137, 3797, 739397);

    public boolean completePrime(int num) {
        return completePrimes.contains(num);
    }
}
