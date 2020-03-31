package leetcode.leetcode0xx.leetcode49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                CanonicalForm::new, Collectors.toList()
        )).values());
    }

    private static class CanonicalForm {
        private int[] count;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CanonicalForm that = (CanonicalForm) o;
            return Arrays.equals(count, that.count);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(count);
        }

        public CanonicalForm(String str) {
            this.count = new int[26];
            for (char c : str.toCharArray()) {
                count[c - 'a']++;
            }
        }
    }
}
