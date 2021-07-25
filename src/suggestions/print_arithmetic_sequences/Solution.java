package suggestions.print_arithmetic_sequences;

import java.util.*;

/*
Given an integer array nums, return all DISTINCT arithmetic subsequences of nums.

A sequence of numbers is called arithmetic if it consists of at least THREE element and if the difference between any two consecutive elements is the same.

For example, [1, 3, 5, 7, 9], [7, 7, 7, 7], and [-9, -5, -1, 3] are arithmetic sequences.
For example, [1, 1, 2, 5, 7] is not an arithmetic sequence.
A subsequence of an array is a sequence that can be formed by removing some elements (possibly none) of the array.
 */


public class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) countMap.compute(num, (k, v) -> v == null ? 1 : v + 1);

        HashMap<SequenceGroupId, SequenceGroup> map = new HashMap<>();
        int n = nums.length;
        for (int j = 1; j < n; j++) {
            long num2 = nums[j];
            for (int i = 0; i < j; i++) {
                long num1 = nums[i];
                if (num2 == num1) continue;
                long diff = num2 - num1;
                num1 %= diff;
                if (num1 * diff < 0) num1 += diff;
                long index = (num2 - num1) / diff;
                SequenceGroupId groupId = new SequenceGroupId(num1, diff);
                map.computeIfAbsent(groupId, key -> new SequenceGroup(index)).add(index);
            }
        }

        AnswerList ans = new AnswerList();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 2) ans.add(new SameIntegerSequence(entry.getKey(), entry.getValue()));
        }

        for (Map.Entry<SequenceGroupId, SequenceGroup> entry : map.entrySet()) {
            long prevRight = Long.MIN_VALUE;
            for (Map.Entry<Long, Long> segment : entry.getValue().rightMap.entrySet()) {
                long right = segment.getKey();
                long left = segment.getValue();
                long len = right - left;
                if (len >= 2) {
                    ans.add(new SequenceListList(
                            entry.getKey().min, entry.getKey().diff,
                            segment.getValue(), segment.getKey(), prevRight
                    ));
                }
                prevRight = segment.getKey();
            }
        }
        return ans;
    }

    private static class AnswerList extends AbstractList<List<Integer>> {
        private final List<Integer> indices = new ArrayList<>();
        private final List<List<List<Integer>>> list = new ArrayList<>();
        private int size = 0;

        void add(List<List<Integer>> integers) {
            list.add(integers);
            indices.add(size);
            size += integers.size();
        }

        @Override
        public List<Integer> get(int index) {
            int lo = 0, hi = indices.size() - 1;
            while (lo < hi) {
                int mid = lo + (hi - lo + 1) / 2;
                if (indices.get(mid) > index) hi = mid - 1;
                else lo = mid;
            }
            return list.get(lo).get(index - indices.get(lo));
        }

        @Override
        public int size() {
            return size;
        }
    }

    private static class SameIntegerSequence extends AbstractList<List<Integer>> {
        private final int val, maxLength;

        public SameIntegerSequence(int val, int maxLength) {
            this.val = val;
            this.maxLength = maxLength;
        }

        @Override
        public List<Integer> get(int index) {
            return new SameIntegerList(val, index + 3);
        }

        @Override
        public int size() {
            return maxLength - 2;
        }
    }

    private static class SameIntegerList extends AbstractList<Integer> {
        private final int val, size;

        SameIntegerList(int val, int size) {
            this.val = val;
            this.size = size;
        }

        @Override
        public Integer get(int index) {
            return val;
        }

        @Override
        public int size() {
            return size;
        }
    }

    private static class SequenceListList extends AbstractList<List<Integer>> {
        private final long min, diff, left, right, prevRight;

        public SequenceListList(long min, long diff, long left, long right, long prevRight) {
            this.min = min;
            this.diff = diff;
            this.left = left;
            this.right = right;
            this.prevRight = prevRight;
        }

        private static int solve(int n) {
            int x = (int) Math.ceil((Math.sqrt(8 * n + 1) - 1) / 2);
            if (x * (x + 1) / 2 < n) x++;
            return x;
        }

        @Override
        public List<Integer> get(int index) {
            int inter = (int) (Math.max(prevRight, left) - left);
            if (inter > 1) index += inter * (inter - 1) / 2;
            int x = solve(index + 1) - 1;
            int y = index - x * (x + 1) / 2;
            return new SequenceList(
                    (int) (min + diff * (left + y)),
                    diff,
                    x + 3 - y
            );
        }

        @Override
        public int size() {
            long len = right - left;
            long inter = Math.max(prevRight, left) - left;
            return (int) ((len * (len - 1) - inter * (inter - 1)) / 2);
        }
    }

    private static class SequenceList extends AbstractList<Integer> {
        final int start, length;
        final long diff;

        SequenceList(int start, long diff, int length) {
            this.start = start;
            this.diff = diff;
            this.length = length;
        }

        @Override
        public Integer get(int index) {
            return (int) (start + diff * index);
        }

        @Override
        public int size() {
            return length;
        }
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
