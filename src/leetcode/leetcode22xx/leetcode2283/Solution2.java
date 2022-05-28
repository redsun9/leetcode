package leetcode.leetcode22xx.leetcode2283;

import java.util.Set;

public class Solution2 {
    private static final Set<String> set = Set.of("1210", "2020", "21200", "3211000", "42101000", "521001000",
            "6210001000", "72100001000", "821000001000", "9210000001000");

    public boolean digitCount(String num) {
        return set.contains(num);
    }
}
