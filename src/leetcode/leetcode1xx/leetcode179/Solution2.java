package leetcode.leetcode1xx.leetcode179;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// extend number to the same length by repeating digits
public class Solution2 {
    private static final long[] tens = {
            1L, 10L, 100L, 1000L, 10_000L, 100_000L, 1_000_000L,
            10_000_000L, 100_000_000L, 1_000_000_000L, 10_000_000_000L
    };

    public String largestNumber(int[] nums) {
        int n = nums.length;
        boolean nonZeroExists = false;
        int max = 0;
        for (int num : nums) {
            nonZeroExists |= num != 0;
            max = Math.max(max, num);
        }
        if (!nonZeroExists) return "0";
        int extendedLength = (int) (2 + Math.log10(max));
        long[] extended = new long[n];
        for (int i = 0; i < n; i++) extended[i] = extendNum(nums[i], extendedLength);
        List<Integer> indices = IntStream.range(0, n).boxed()
                .sorted(Comparator.comparingLong(ind -> -extended[ind]))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[indices.get(i)]);
        }
        return sb.toString();

    }

    private static long extendNum(int num, int targetLength) {
        if (num == 0) return 0;
        int originalLength = (int) (1 + Math.log10(num));
        int currentLength = originalLength;
        long tmp = num;
        while (currentLength + originalLength <= targetLength) {
            tmp = tmp * tens[originalLength] + num;
            currentLength += originalLength;
        }
        if (currentLength != targetLength) {
            tmp = tmp * tens[targetLength - currentLength]
                    + num / tens[originalLength - (targetLength - currentLength)];
        }
        return tmp;
    }

}
