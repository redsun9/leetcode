package leetcode.leetcode9xx.leetcode966;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    private final static int shift = 'a' - 'A';
    private final Set<String> exactSet = new HashSet<>();
    private final Map<String, String> capMap = new HashMap<>();
    private final Map<String, String> vowelMap = new HashMap<>();

    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        for (int i = n - 1; i >= 0; i--) {
            String word = wordlist[i];
            exactSet.add(word);

            char[] s = word.toCharArray();
            int length = s.length;
            for (int j = 0; j < length; j++) if (s[j] >= 'A' && s[j] <= 'Z') s[j] += shift;
            capMap.put(new String(s), word);

            for (int j = 0; j < length; j++) {
                if (s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u') s[j] = '#';
            }
            vowelMap.put(new String(s), word);
        }
        int m = queries.length;
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            String query = queries[i];
            if (exactSet.contains(query)) {
                ans[i] = query;
                continue;
            }

            char[] s = query.toCharArray();
            int length = s.length;
            for (int j = 0; j < length; j++) if (s[j] >= 'A' && s[j] <= 'Z') s[j] += shift;
            String cap = capMap.get(new String(s));
            if (cap != null) {
                ans[i] = cap;
                continue;
            }
            for (int j = 0; j < length; j++) {
                if (s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u') s[j] = '#';
            }
            cap = vowelMap.get(new String(s));
            if (cap != null) {
                ans[i] = cap;
                continue;
            }
            ans[i] = "";
        }
        return ans;
    }
}
