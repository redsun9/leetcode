package firecode;

import java.util.HashSet;

public class RemoveDuplicates {
    public ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;
        HashSet<Integer> seen = new HashSet<>();
        seen.add(head.data);
        ListNode tmp = head;
        while (tmp.next != null) {
            if (!seen.add(tmp.next.data)) tmp.next = tmp.next.next;
            else tmp = tmp.next;
        }
        return head;
    }
}
