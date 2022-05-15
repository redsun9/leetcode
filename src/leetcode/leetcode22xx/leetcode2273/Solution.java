package leetcode.leetcode22xx.leetcode2273;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n = words.length;
        if (n <= 1) return List.of(words);
        List<String> ans = new ArrayList<>();
        int[] prevCount = new int[26], currCount = new int[26], tmpCount;
        prevCount[0] = -1;
        for (String word : words) {
            count(word, currCount);
            if (!Arrays.equals(currCount, prevCount)) {
                ans.add(word);
                tmpCount = prevCount;
                prevCount = currCount;
                currCount = tmpCount;
            }
        }
        return ans;
    }


    private static void count(String word, int[] count) {
        int m = word.length();
        Arrays.fill(count, 0);
        for (int i = 0; i < m; i++) count[word.charAt(i) - 'a']++;
    }
}
