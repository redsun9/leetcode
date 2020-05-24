package leetcode.leetcode8xx.leetcode817;

import leetcode.tools.ListNode;

import java.util.HashSet;

public class Solution {
    public int numComponents(ListNode head, int[] g) {
        if (head == null || g.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int a : g) set.add(a);
        int ans = 0;
        boolean prev = false;
        while (head != null) {
            boolean curr = set.contains(head.val);
            if (curr && !prev) ans++;
            prev = curr;
            head = head.next;
        }
        return ans;
    }
}
