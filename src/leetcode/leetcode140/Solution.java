package leetcode.leetcode140;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty() || wordDict.isEmpty()) return Collections.emptyList();
        final int n = s.length();
        char[] strChars = s.toCharArray();
        Map<Character, Boolean> characterBooleanMap = s.chars()
                .mapToObj(c -> Character.valueOf((char) c))
                .distinct()
                .collect(Collectors.toMap(Function.identity(), x -> false));
        ArrayList<String> filteredWords = new ArrayList<>(wordDict.size());
        WordTree wordTree = new WordTree();
        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            char[] wordCharArray = word.toCharArray();
            //check that all char consists in string
            boolean allFound = true;
            for (char c : wordCharArray) {
                if (!characterBooleanMap.containsKey(c)) {
                    allFound = false;
                    break;
                }
            }
            if (allFound) {
                for (char c : wordCharArray) {
                    characterBooleanMap.put(c, true);
                }
                wordTree.addWord(wordCharArray, 0, filteredWords.size());
                filteredWords.add(word);
            }
        }

        if (characterBooleanMap.containsValue(false)) {
            return Collections.emptyList();
        }
        LinkedList<String>[] dp = new LinkedList[n + 1];
        boolean[] prevOk = new boolean[n + 1];
        prevOk[0] = true;
        for (int i = 0; i < n; i++) {
            if (prevOk[i]) {
                WordTree tmpTree = wordTree;
                int tmpCounter = i;
                while (tmpCounter < n) {
                    tmpTree = tmpTree.tree.get(strChars[tmpCounter]);
                    tmpCounter++;
                    if (tmpTree == null) break;
                    if (tmpTree.wordIndex != -1) {
                        prevOk[tmpCounter] = true;
                        if (dp[tmpCounter] == null) {
                            dp[tmpCounter] = new LinkedList<>();
                        }
                        dp[tmpCounter].add(filteredWords.get(tmpTree.wordIndex));
                    }
                }
            }
        }
        List<String>[] subResult = new List[n];
        for (int i = 0; i < n; i++) {
            subResult[i] = new LinkedList<>();
        }
        if (prevOk[n]) {
            for (String afterString : dp[n]) {
                subResult[n - afterString.length()].add(afterString);
            }
            dp[n] = null;
            for (int i = n - 1; i > 0; i--) {
                if (prevOk[i]) {
                    List<String> afterStrings = subResult[i];
                    LinkedList<String> beforeStrings = dp[i];
                    for (String beforeString : beforeStrings) {
                        List<String> list = subResult[i - beforeString.length()];
                        for (String afterString : afterStrings) {
                            list.add(beforeString + " " + afterString);
                        }
                    }
                }
                subResult[i] = null;
                dp[i] = null;
            }
        } else {
            return Collections.emptyList();
        }
        return subResult[0];
    }

    private static class WordTree {
        private final HashMap<Character, WordTree> tree;
        private int wordIndex = -1;

        private WordTree() {
            this.tree = new HashMap<>();
        }

        private void addWord(char[] str, int pos, int wordIndex) {
            if (pos == str.length) {
                this.wordIndex = wordIndex;
            } else {
                char c = str[pos];
                WordTree wordTree = tree.get(c);
                if (wordTree == null) {
                    wordTree = new WordTree();
                    tree.put(c, wordTree);
                }
                wordTree.addWord(str, pos + 1, wordIndex);
            }
        }
    }
}
