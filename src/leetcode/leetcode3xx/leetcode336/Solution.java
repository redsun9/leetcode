package leetcode.leetcode3xx.leetcode336;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "unchecked"})
public class Solution {
    private static final int alphabetSize = 26;

    public List<List<Integer>> palindromePairs(String[] words) {
        int maxNeeded = 1;
        for (String word : words) maxNeeded += word.length();


        int[][] child1 = new int[alphabetSize][maxNeeded];
        int[] index1 = new int[maxNeeded];
        List<Integer>[] pals1 = new List[maxNeeded];
        int nxt1 = 1;

        int[][] child2 = new int[alphabetSize][maxNeeded];
        int[] index2 = new int[maxNeeded];
        List<Integer>[] pals2 = new List[maxNeeded];
        int nxt2 = 1;

        int n = words.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int index = 0; index < n; index++) {
            String word = words[index];
            int len = word.length();
            String reversed = new StringBuilder(word).reverse().toString();

            int[] zf1 = zFunction(word + "#" + reversed);
            int[] zf2 = zFunction(reversed + "#" + word);
            boolean[] isPal1 = new boolean[len];
            boolean[] isPal2 = new boolean[len];

            for (int pos = len - 1, i = len + 1, j = len; pos >= 0; pos--, j--, i++) isPal1[pos] = zf1[i] == j;
            for (int pos = 0, i = len + 1, j = len; pos < len; pos++, j--, i++) isPal2[pos] = zf2[i] == j;

            int node = 0;
            int i = len - 1;
            while (i >= 0) {
                if (isPal1[i] && index1[node] != 0) ans.add(List.of(index1[node] - 1, index));
                int c = word.charAt(i) - 'a';
                if (child1[c][node] == 0) break;
                node = child1[c][node];
                i--;
            }
            if (i < 0 && pals1[node] != null) for (Integer ind : pals1[node]) ans.add(List.of(ind, index));
            if (i < 0 && index1[node] != 0) ans.add(List.of(index1[node] - 1, index));

            node = 0;
            i = 0;
            while (i < len) {
                if (isPal2[i] && index2[node] != 0) ans.add(List.of(index, index2[node] - 1));
                int c = word.charAt(i) - 'a';
                if (child2[c][node] == 0) break;
                node = child2[c][node];
                i++;
            }
            if (i == len && pals2[node] != null) for (Integer ind : pals2[node]) ans.add(List.of(index, ind));
            if (i == len && index2[node] != 0) ans.add(List.of(index, index2[node] - 1));

            node = 0;
            i = 0;
            while (i < len) {
                if (isPal2[i]) {
                    if (pals1[node] == null) pals1[node] = new ArrayList<>();
                    pals1[node].add(index);
                }
                int c = word.charAt(i) - 'a';
                if (child1[c][node] == 0) child1[c][node] = nxt1++;
                node = child1[c][node];
                i++;
            }
            index1[node] = index + 1;

            node = 0;
            i = len - 1;
            while (i >= 0) {
                if (isPal1[i]) {
                    if (pals2[node] == null) pals2[node] = new ArrayList<>();
                    pals2[node].add(index);
                }
                int c = word.charAt(i) - 'a';
                if (child2[c][node] == 0) child2[c][node] = nxt2++;
                node = child2[c][node];
                i--;
            }
            index2[node] = index + 1;
        }
        return ans;
    }

    private static int[] zFunction(String s) {
        int n = s.length();
        int[] zf = new int[n];
        int left = 0, right = 0;
        for (int i = 1; i < n; i++) {
            zf[i] = Math.max(0, Math.min(right - i, zf[i - left]));
            while (i + zf[i] < n && s.charAt(zf[i]) == s.charAt(i + zf[i])) zf[i]++;
            if (i + zf[i] > right) {
                left = i;
                right = i + zf[i];
            }
        }
        return zf;
    }
}
