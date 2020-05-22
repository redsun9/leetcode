package leetcode.leetcode8xx.leetcode894;

import leetcode.tools.TreeNode;

import java.util.*;

public class Solution {
    private final static Map<Integer, List<TreeNode>> cache = new HashMap<>();

    static {
        cache.put(1, Collections.singletonList(new TreeNode(0)));
    }

    public List<TreeNode> allPossibleFBT(final int n) {
        if ((n & 1) != 1) return Collections.emptyList();
        if (cache.containsKey(n)) return cache.get(n);

        List<TreeNode> ans = new LinkedList<>();
        for (int i = 2; i < n; i += 2) {
            List<TreeNode> lefts = allPossibleFBT(i - 1);
            List<TreeNode> rights = allPossibleFBT(n - i);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    ans.add(new TreeNode(0, left, right));
                }
            }
        }
        cache.put(n, ans);
        return ans;
    }
}
