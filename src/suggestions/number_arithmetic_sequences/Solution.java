package suggestions.number_arithmetic_sequences;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/*
Given an integer array nums, return number of all DISTINCT increasing arithmetic subsequences of nums.

A sequence of numbers is called arithmetic if it consists of at least THREE element and if the difference between any two consecutive elements is the same.

For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [-9, -5, -1, 3] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 */


public class Solution {
    public long findSubsequences(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.compute(num, (k, v) -> v == null ? 1 : v + 1);

        HashMap<SequenceGroupId, SequenceGroup> map = new HashMap<>();
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            long num2 = nums[j];
            for (int i = 0; i < j; i++) {
                long num1 = nums[i];
                if (nums[j] == num1) continue;
                long diff = num2 - num1;
                num1 %= diff;
                if (num1 * diff < 0) num1 += diff;
                long index = (num2 - num1) / diff;
                SequenceGroupId groupId = new SequenceGroupId(num1, diff);
                map.computeIfAbsent(groupId, key -> new SequenceGroup(index)).add(index);
            }
        }

        long ans = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 2) ans += entry.getValue() - 2;
        }

        for (Map.Entry<SequenceGroupId, SequenceGroup> entry : map.entrySet()) {
            long prevRight = Long.MIN_VALUE;
            for (Map.Entry<Long, Long> segment : entry.getValue().rightMap.entrySet()) {
                long right = segment.getKey();
                long left = segment.getValue();
                long len = right - left;
                long inter = Math.max(prevRight, left) - left;
                ans += ((len * (len - 1) - inter * (inter - 1)) / 2);
                prevRight = right;
            }
        }
        return ans;
    }

    private static class SequenceGroupId {
        final long min, diff;

        public SequenceGroupId(long min, long diff) {
            this.min = min;
            this.diff = diff;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SequenceGroupId that = (SequenceGroupId) o;
            return min == that.min && diff == that.diff;
        }

        @Override
        public int hashCode() {
            return Objects.hash(min, diff);
        }
    }

    private static class SequenceGroup {
        final TreeMap<Long, Long> rightMap = new TreeMap<>();

        SequenceGroup(long index) {
            rightMap.put(index, index - 1);
        }

        void add(long idx) {
            Long floor = rightMap.get(idx - 1);
            if (floor != null) {
                rightMap.remove(idx - 1);
                rightMap.put(idx, floor);
                return;
            }
            Map.Entry<Long, Long> ceiling = rightMap.ceilingEntry(idx);
            if (ceiling != null && ceiling.getValue() < idx) return;
            rightMap.put(idx, idx - 1);
        }
    }
}
