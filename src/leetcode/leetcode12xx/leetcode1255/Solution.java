package leetcode.leetcode12xx.leetcode1255;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        if (words.length == 0 || letters.length == 0) return 0;
        ArrayList<Map<Character, Integer>> wordConsists = new ArrayList<>(words.length);
        ArrayList<Integer> wordCost = new ArrayList<>(words.length);
        Map<Character, Integer> letterCount = new HashMap<>();
        HashSet<Character> usedInWords = new HashSet<>();
        for (char c : letters) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }
        for (String word : words) {
            char[] chars = word.toCharArray();
            int cost = 0;
            Map<Character, Integer> charCounter = new HashMap<>();
            boolean failed = false;
            for (char c : chars) {
                charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
                if (charCounter.get(c) > letterCount.getOrDefault(c, 0)) {
                    failed = true;
                    break;
                }
                cost += score[c - 'a'];
            }
            if (!failed) {
                wordConsists.add(charCounter);
                usedInWords.addAll(charCounter.keySet());
                wordCost.add(cost);
            }
        }
        int[][] goods = new int[wordConsists.size()][usedInWords.size()];
        int[] costs = new int[wordConsists.size()];
        int[] supply = new int[usedInWords.size()];
        int i = 0;
        for (Character character : usedInWords) {
            for (int j = 0; j < wordConsists.size(); j++) {
                Map<Character, Integer> integerMap = wordConsists.get(j);
                goods[j][i] = integerMap.getOrDefault(character, 0);
            }
            supply[i] = letterCount.get(character);
            i++;
        }
        for (int j = 0; j < wordConsists.size(); j++) {
            costs[j] = wordCost.get(j);
        }
        return maxBag(goods, costs, supply, 0);
    }


    private static int maxBag(
            int[][] goods, int[] costs,
            int[] supply, final int i) {
        if (i >= goods.length) return 0;
        int max = Integer.MAX_VALUE;
        for (int j = 0; j < supply.length; j++) {
            if (goods[i][j] != 0) max = Math.min(max, supply[j] / goods[i][j]);
        }
        //TODO: only for leetcode
        max = Math.min(max, 1);
        if (i == goods.length - 1) return costs[i] * max;
        int k = 0;
        int res = 0;
        while (true) {
            res = Math.max(res, costs[i] * k + maxBag(goods, costs, supply, i + 1));
            if (k == max) {
                if (k != 0) {
                    for (int j = 0; j < supply.length; j++) {
                        supply[j] += goods[i][j] * k;
                    }
                }
                break;
            } else {
                k++;
                for (int j = 0; j < supply.length; j++) {
                    supply[j] -= goods[i][j];
                }
            }
        }
        return res;
    }
}
