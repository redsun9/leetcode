package leetcode.leetcode6xx.leetcode691;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    private boolean isDebug = false;

    public int minStickers(String[] stickers, String target) {
        if (stickers.length == 0) {
            if (!target.isEmpty()) return -1;
            else return 0;
        }
        if (target.isEmpty()) return 0;
        Map<Integer, Set<Map<Character, Integer>>> wordConsists = new HashMap<>(stickers.length * 2);
        Map<Character, Integer> letterCount = new HashMap<>();
        HashSet<Character> usedInWords = new HashSet<>();
        for (char c : target.toCharArray()) {
            letterCount.put(c, letterCount.getOrDefault(c, 0) + 1);
        }
        for (String word : stickers) {
            int cap = 0;
            Map<Character, Integer> charCounter = new HashMap<>();
            for (char c : word.toCharArray()) {
                if (letterCount.containsKey(c)) {
                    cap++;
                    charCounter.put(c, charCounter.getOrDefault(c, 0) + 1);
                }
            }
            if (cap != 0) {
                Set<Map<Character, Integer>> mapSet = wordConsists.getOrDefault(cap, new HashSet<>());
                if (!mapSet.contains(charCounter)) {
                    mapSet.add(charCounter);
                    usedInWords.addAll(charCounter.keySet());
                    wordConsists.put(cap, mapSet);
                } else if (isDebug) {
                    System.out.println("Duplicate - " + word);
                }
            }
        }

        HashSet<Map<Character, Integer>> removed = new HashSet<>();

        List<Integer> lengthWords = wordConsists.keySet().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for (int i = 0; i < lengthWords.size() - 1; i++) {
            Set<Map<Character, Integer>> bigWords = wordConsists.get(lengthWords.get(i));
            for (Map<Character, Integer> bigWord : bigWords) {
                if (!removed.contains(bigWord)) {
                    for (int j = i + 1; j < lengthWords.size(); j++) {
                        Set<Map<Character, Integer>> littleWords = wordConsists.get(lengthWords.get(j));
                        for (Map<Character, Integer> littleWord : littleWords) {
                            if (!removed.contains(littleWord)) {
                                if (isWorse(littleWord, bigWord)) {
                                    if (isDebug) System.out.println(bigWord + " > " + littleWord);
                                    removed.add(littleWord);
                                }
                            }
                        }
                    }
                }
            }
        }
        List<Map<Character, Integer>> goodWords = wordConsists.values().parallelStream()
                .flatMap(Collection::stream)
                .filter(set -> !removed.contains(set))
                .collect(Collectors.toList());

        if (isDebug) {
            System.out.println("Different words - " + goodWords.size());
            System.out.println(goodWords.toString());
        }
        if (!usedInWords.equals(letterCount.keySet())) {
            return -1;
        }
        int[][] goods = new int[goodWords.size()][letterCount.size()];
        int[] supply = new int[letterCount.size()];
        int i = 0;
        for (Character character : letterCount.keySet()) {
            for (int j = 0; j < goodWords.size(); j++) {
                Map<Character, Integer> integerMap = goodWords.get(j);
                goods[j][i] = integerMap.getOrDefault(character, 0);
            }
            supply[i] = letterCount.get(character);
            i++;
        }
        int res = minSticker(goods, supply, 0);
        return res >= 0 ? res : -1;
    }

    private static int minSticker(
            int[][] goods, int[] supply, final int currIndex
    ) {
        if (currIndex >= goods.length) return isCovered(supply);
        int maxUseful = maxUseful(goods, currIndex, supply);

        if (currIndex == goods.length - 1) {
            int canCover = canCover(goods, currIndex, supply);
            return canCover == 0 ? maxUseful : canCover;
        }
        int k = maxUseful;
        int res;
        dec(goods, currIndex, k, supply);
        int tmp = minSticker(goods, supply, currIndex + 1);
        if (tmp < 0) {
            res = tmp;
        } else {
            res = k + tmp;
            while (k != 0) {
                k--;
                dec(goods, currIndex, -1, supply);
                tmp = minSticker(goods, supply, currIndex + 1);
                if (tmp < 0) {
                    break;
                } else {
                    res = Math.min(res, k + tmp);
                }
            }
        }
        dec(goods, currIndex, -k, supply);
        return res;
    }

    private static void dec(int[][] goods, int i, int k, int[] supply) {
        if (k == 0) return;
        for (int j = 0; j < supply.length; j++) {
            supply[j] = supply[j] - goods[i][j] * k;
        }
    }

    private static int maxUseful(int[][] goods, int i, int[] supply) {
        int max = 0;
        for (int j = 0; j < supply.length; j++) {
            if (goods[i][j] != 0 && supply[j] > 0) {
                if (goods[i][j] != 1) {
                    max = Math.max(max, (supply[j] + goods[i][j] - 1) / goods[i][j]);
                } else {
                    max = Math.max(max, supply[j]);
                }
            }
        }
        return max;
    }

    private static int isCovered(int[] supply) {
        for (int j = 0; j < supply.length; j++) {
            if (supply[j] > 0) return -(j + 1);
        }
        return 0;
    }

    private static int canCover(int[][] goods, int i, int[] supply) {
        for (int j = 0; j < supply.length; j++) {
            if (supply[j] > 0 && goods[i][j] == 0) return -(j + 1);
        }
        return 0;
    }

    private static boolean isWorse(Map<Character, Integer> a, Map<Character, Integer> b) {
        for (Character character : a.keySet()) {
            if (a.get(character) > b.getOrDefault(character, 0)) return false;
        }
        return true;
    }
}
