package sber;

import java.util.*;

public class Transliterator {
    public Collection<String> getPossibleTransliterations(String s, Map<Character, Character> keyToValue) {
        char[] str = s.toCharArray();
        int n = str.length;
        char[][] dict = new char[keyToValue.size()][2]; //first alphabet, second alphabet
        int charId = 0;
        Map<Character, Integer> charIdMap = new HashMap<>(); //char to id
        for (Map.Entry<Character, Character> entry : keyToValue.entrySet()) {
            dict[charId][0] = entry.getKey();
            dict[charId][1] = entry.getValue();
            charIdMap.put(entry.getKey(), charId);
            charIdMap.put(entry.getValue(), charId);
            charId++;
        }

        int[][] positions = new int[n][2]; // position, char id
        int posIndex = 0;
        for (int i = 0; i < n; i++) {
            Integer value = charIdMap.get(str[i]);
            if (value != null) {
                positions[posIndex][0] = i;
                positions[posIndex][1] = value;
                posIndex++;
            }
        }
        List<String> ans = new ArrayList<>(1 << posIndex);
        dfs(str, dict, positions, 0, posIndex, ans);
        return ans;
    }

    private static void dfs(
            char[] tmp, char[][] dict, int[][] positions,
            int curIndex, int maxIndex, Collection<String> ans
    ) {
        if (curIndex == maxIndex) {
            ans.add(new String(tmp));
        } else {
            tmp[positions[curIndex][0]] = dict[positions[curIndex][1]][0];
            dfs(tmp, dict, positions, curIndex + 1, maxIndex, ans);
            tmp[positions[curIndex][0]] = dict[positions[curIndex][1]][1];
            dfs(tmp, dict, positions, curIndex + 1, maxIndex, ans);
        }
    }
}
