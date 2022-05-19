package leetcode.leetcode7xx.leetcode784;

import java.util.AbstractList;
import java.util.List;

public class Solution2 {
    public List<String> letterCasePermutation(String s) {
        return new MyList(s);
    }

    private static class MyList extends AbstractList<String> {
        final char[] chars;
        final int[] positions;
        final int numberOfLetters;

        MyList(String s) {
            chars = s.toCharArray();
            positions = new int[12];
            int numberOfLetters = 0;
            for (int i = 0; i < chars.length; i++) {
                if (chars[i] >= 'A' && chars[i] <= 'Z') {
                    chars[i] += 32;
                    positions[numberOfLetters++] = i;
                } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                    positions[numberOfLetters++] = i;
                }
            }
            this.numberOfLetters = numberOfLetters;
        }

        @Override
        public String get(int index) {
            for (int i = 0; i < numberOfLetters; i++) if ((index >> i & 1) == 1) chars[positions[i]] -= 32;
            String ans = new String(chars);
            for (int i = 0; i < numberOfLetters; i++) if ((index >> i & 1) == 1) chars[positions[i]] += 32;
            return ans;
        }

        @Override
        public int size() {
            return 1 << numberOfLetters;
        }
    }
}
