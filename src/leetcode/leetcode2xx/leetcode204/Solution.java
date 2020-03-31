package leetcode.leetcode2xx.leetcode204;

import java.util.BitSet;

public class Solution {
    public int countPrimes(int n) {
        if (n < 3) return 0;
        int nbits = n / 2 - 1;
        BitSet bitSet = new BitSet(nbits);
        bitSet.set(0, nbits);
        int maxCheck = (int) (Math.ceil(Math.sqrt(n - 1)) - 3) / 2;
        for (int i = 0; i <= maxCheck; i++) {
            if (bitSet.get(i)) {
                int p = i * 2 + 3;
                for (int j = (p * p - 3) / 2; j < nbits; j += p) {
                    bitSet.set(j, false);
                }
            }
        }
        return bitSet.cardinality() + 1;
    }
}
