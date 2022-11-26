package leetcode.leetcode24xx.leetcode2471;

import leetcode.tools.TreeNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;

@SuppressWarnings("DataFlowIssue")
public class Solution {
    public int minimumOperations(TreeNode root) {
        int ans = 0;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                root = queue.pollFirst();
                arr[i][0] = root.val;
                arr[i][1] = i;
                if (root.left != null) queue.addLast(root.left);
                if (root.right != null) queue.addLast(root.right);
            }
            ans += helper(arr);
        }
        return ans;
    }

    private static int helper(int[][] arr) {
        int n = arr.length, ans = n, j1, j2;
        Arrays.sort(arr, Comparator.comparingInt(x -> x[0]));
        for (int i = 0; i < n; i++) {
            if (arr[i][1] >= 0) {
                ans--;
                j1 = i;
                while (arr[j1][1] != -1) {
                    j2 = arr[j1][1];
                    arr[j1][1] = -1;
                    j1 = j2;
                }
            }
        }
        return ans;
    }
}
