package leetcode.leetcode1xx.leetcode179;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {
    public String largestNumber(int[] nums) {
        int n = nums.length;
        boolean nonZeroExists = false;
        int max = 0;
        for (int num : nums) {
            nonZeroExists |= num != 0;
            max = Math.max(max, num);
        }
        if (!nonZeroExists) return "0";
        int extendedLength = 2 * (int) (1 + Math.log10(max));

        int[][] child = new int[n * extendedLength + 1][];
        child[0] = new int[10];
        List<Integer>[] words = new List[n * extendedLength + 1];
        int nxt = 1;

        int[] digits = new int[10];
        for (int num : nums) {
            int tmp = num;
            int digitNumber = 0;
            do {
                digits[digitNumber++] = tmp % 10;
                tmp /= 10;
            } while (tmp != 0);
            int node = 0;
            for (int i = 0, j = digitNumber - 1; i < extendedLength; i++, j = (j + digitNumber - 1) % digitNumber) {
                int c = digits[j];
                if (child[node][c] == 0) {
                    child[nxt] = new int[10];
                    child[node][c] = nxt++;
                }
                node = child[node][c];
            }
            if (words[node] == null) words[node] = new LinkedList<>();
            words[node].add(num);
        }

        StringBuilder sb = new StringBuilder(n * (extendedLength - 1));
        ArrayDeque<Integer> stack = new ArrayDeque<>(extendedLength * 10);
        stack.push(0);
        while (!stack.isEmpty()) {
            Integer node = stack.pop();
            for (int i = 0; i <= 9; i++) {
                if (child[node][i] != 0) stack.push(child[node][i]);
            }
            if (words[node] != null) {
                for (Integer num : words[node]) sb.append(num);
            }
        }
        return sb.toString();
    }
}
