package leetcode.leetcode14xx.leetcode1452;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        if (n == 1) return Collections.singletonList(0);
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, Comparator.comparingInt(x -> -favoriteCompanies.get(x).size()));
        HashMap<String, Integer> companyToInt = new HashMap<>();

        ArrayList<BigInteger> bitsets = new ArrayList<>(n);
        int companyCounter = 0;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Integer index = indices[i];
            List<String> list = favoriteCompanies.get(index);
            BigInteger bs = BigInteger.ZERO;
            for (String s : list) {
                if (companyToInt.containsKey(s)) {
                    bs = bs.or(BigInteger.ONE.shiftLeft(companyToInt.get(s)));
                } else {
                    bs = bs.or(BigInteger.ONE.shiftLeft(companyCounter));
                    companyToInt.put(s, companyCounter++);
                }
            }
            boolean isSubset = false;
            for (BigInteger bitset : bitsets) {
                if (bitset.or(bs).equals(bitset)) {
                    isSubset = true;
                    break;
                }
            }
            if (!isSubset) {
                ans.add(index);
                bitsets.add(bs);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
