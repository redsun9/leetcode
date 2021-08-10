package leetcode.leetcode8xx.leetcode869;

import java.util.Set;

public class Solution {
    private static final Set<Long> set = Set.of(
            1L, 2L, 4L, 8L, 61L, 32L, 64L, 821L, 652L, 521L, 4210L, 8420L, 9640L, 9821L, 86431L, 87632L,
            66553L, 732110L, 644221L, 885422L, 8765410L, 9752210L, 9444310L, 8888630L, 77766211L,
            55443332L, 88766410L, 877432211L, 866554432L, 987653210L, 8774432110L, 8876444321L
    );

    public boolean reorderedPowerOf2(int n) {
        int[] count = new int[10];
        while (n != 0) {
            count[n % 10]++;
            n /= 10;
        }
        long key = 0;
        for (int i = 9; i >= 0; i--) for (int j = count[i]; j > 0; j--) key = key * 10L + i;
        return set.contains(key);
    }
}
