package help_requests.mastermind;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] getResponse(int[] pattern, int[] guess) {
        int n = pattern.length;
        Map<Integer, Integer> patternMap = new HashMap<>();
        Map<Integer, Integer> guessMap = new HashMap<>();

        int perfectCount = 0;
        for (int i = 0; i < n; i++) {
            if (pattern[i] == guess[i]) perfectCount++;
            else {
                patternMap.compute(pattern[i], (k, v) -> v == null ? 1 : v + 1);
                guessMap.compute(guess[i], (k, v) -> v == null ? 1 : v + 1);
            }
        }

        int wrongPositionCount = 0;
        for (Map.Entry<Integer, Integer> guessEntry : guessMap.entrySet()) {
            wrongPositionCount += Math.min(guessEntry.getValue(), patternMap.getOrDefault(guessEntry.getKey(), 0));
        }
        return new int[]{perfectCount, wrongPositionCount};
    }
}
