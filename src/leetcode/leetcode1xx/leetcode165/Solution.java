package leetcode.leetcode1xx.leetcode165;

public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        int n1 = split1.length;
        int n2 = split2.length;
        int i = 0;
        for (; i < n1 && i < n2; i++) {
            int compare = Integer.compare(Integer.parseInt(split1[i]), Integer.parseInt(split2[i]));
            if (compare != 0) return Integer.signum(compare);
        }
        while (i < n1 && Integer.parseInt(split1[i]) == 0) i++;
        while (i < n2 && Integer.parseInt(split2[i]) == 0) i++;
        if (i >= n1 && i >= n2) return 0;
        return Integer.compare(n1, n2);
    }
}
