package leetcode.leetcode7xx.leetcode725;

import leetcode.tools.ListNode;

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] ans = new ListNode[k];
        int length = 0;
        ListNode tmp = root;
        while (tmp != null) {
            length++;
            tmp = tmp.next;
        }
        for (int i = 0; i < k; i++) {
            ans[i] = root;
            int part = (length + k - 1 - i) / (k - i);
            if (part == 0) break;
            for (int j = 1; j < part; j++) {
                root = root.next;
            }
            tmp = root.next;
            root.next = null;
            root = tmp;
            length -= part;
        }
        return ans;
    }
}
