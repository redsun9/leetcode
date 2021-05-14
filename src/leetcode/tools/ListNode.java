package leetcode.tools;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int x) {
        val = x;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode l1 = this;
        ListNode l2 = (ListNode) o;
        while (l1 != null && l2 != null) {
            if (l1 == l2) return true;
            if (l1.val != l2.val) return false;
            l1 = l1.next;
            l2 = l2.next;
        }
        return l1 == l2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }
}
