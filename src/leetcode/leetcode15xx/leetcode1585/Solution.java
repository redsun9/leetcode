package leetcode.leetcode15xx.leetcode1585;

import java.util.ArrayList;

public class Solution {
    public boolean isTransformable(String s, String t) {
        int n = s.length();
        if (t.length() != n) return false;
        ArrayList<Integer> idx[] = new ArrayList[10];
        int pos[] = new int[10];
        for (int i = 0; i <= 9; i++) idx[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) idx[s.charAt(i) - '0'].add(i);
        for (int i = 0; i < n; i++) {
            int d = t.charAt(i) - '0';
            if (pos[d] >= idx[d].size())
                return false;
            for (int j = 0; j < d; j++)
                if (pos[j] < idx[j].size() && idx[j].get(pos[j]) < idx[d].get(pos[d]))
                    return false;
            pos[d]++;
        }
        return true;
    }
}
