package leetcode.challenge_2020.april7th;

import java.util.HashSet;

public class Solution {
    public int countElements(int[] arr) {
        HashSet<Integer> seen = new HashSet<>();
        for (int a : arr) {
            seen.add(a);
        }
        int count = 0;
        for (Integer a : arr) {
            if (seen.contains(a + 1)) count++;
        }
        return count;
    }
}
