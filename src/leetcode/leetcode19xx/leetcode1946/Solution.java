package leetcode.leetcode19xx.leetcode1946;

public class Solution {
    public String maximumNumber(String num, int[] change) {
        char[] array = num.toCharArray();
        int n = array.length;
        int from = 0;
        while (from < n && change[array[from] - '0'] <= array[from] - '0') from++;
        while (from < n && change[array[from] - '0'] >= array[from] - '0')
            array[from] = (char) (change[array[from++] - '0'] + '0');
        return new String(array);
    }
}
