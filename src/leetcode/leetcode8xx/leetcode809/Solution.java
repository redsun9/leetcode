package leetcode.leetcode8xx.leetcode809;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        if (s.isEmpty()) {
            for (String word : words) if (word.isEmpty()) ans++;
            return ans;
        }
        List<Character> sChars = new ArrayList<>();
        List<Integer> sLengths = new ArrayList<>();

        int start = 0;
        char prev = s.charAt(0);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != prev) {
                sChars.add(prev);
                sLengths.add(i - start);
                prev = s.charAt(i);
                start = i;
            }
        }
        sChars.add(prev);
        sLengths.add(s.length() - start);


        for (String word : words) {
            int lengthJ = word.length();
            if (lengthJ > s.length() || word.isEmpty() || lengthJ < sChars.size()) continue;
            if (lengthJ == s.length()) {
                if (word.equals(s)) ans++;
                continue;
            }
            int i = 0;
            int startJ = 0;
            char prevJ = word.charAt(0);
            if (prevJ != sChars.get(0)) continue;
            boolean ok = true;
            for (int j = 0; ok && j < lengthJ; j++) {
                if (word.charAt(j) != prevJ) {
                    int wLength = j - startJ;
                    int sLength = sLengths.get(i);
                    if (sLength < 3 && wLength != sLength || sLength >= 3 && wLength > sLength) {
                        ok = false;
                        break;
                    }
                    startJ = j;
                    prevJ = word.charAt(j);
                    i++;
                    if (i == sChars.size() || sChars.get(i) != prevJ) {
                        ok = false;
                        break;
                    }
                }
            }
            if (!ok) continue;
            if (i != sChars.size() - 1) continue;
            int lastLengthI = sLengths.get(i);
            int lastLengthJ = word.length() - startJ;
            if (lastLengthI < 3 && lastLengthJ != lastLengthI || lastLengthI >= 3 && lastLengthJ > lastLengthI)
                continue;
            ans++;
        }
        return ans;
    }
}
