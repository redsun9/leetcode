package leetcode.leetcode0xx.leetcode25;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return toString(new HashSet<>());
    }

    private String toString(HashSet<ListNode> seen) {
        seen.add(this);
        if (next == null) return val + "";
        else if (!seen.contains(next)) return val + "->" + next.toString(seen);
        else return val + "->" + next.val + "...";
    }
}
