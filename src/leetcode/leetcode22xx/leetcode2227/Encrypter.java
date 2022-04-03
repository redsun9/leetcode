package leetcode.leetcode22xx.leetcode2227;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Encrypter {
    private final int[] charToPos;
    private final String[] values;
    private final Map<String, Integer> countMap;

    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        this.values = values;
        charToPos = new int[26];
        Arrays.fill(charToPos, -1);
        int k = keys.length;
        for (int i = 0; i < k; i++) charToPos[keys[i] - 'a'] = i;

        countMap = new HashMap<>();
        for (String word : dictionary) {
            countMap.compute(encrypt(word), (key, v) -> v == null ? 1 : v + 1);
        }
    }

    public String encrypt(String word) {
        int n = word.length();
        char[] arr = new char[2 * n];
        for (int i = 0, j = 0; i < n; i++) {
            String s = values[charToPos[word.charAt(i) - 'a']];
            arr[j++] = s.charAt(0);
            arr[j++] = s.charAt(1);
        }
        return new String(arr);
    }

    public int decrypt(String word) {
        return countMap.getOrDefault(word, 0);
    }
}
