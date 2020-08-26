package firecode;

public class LoopingList {
    public boolean isCyclic(ListNode head) {
        if (head == null) return false;
        ListNode a = head, b = head;
        while (a.next != null && a.next.next != null) {
            a = a.next.next;
            b = b.next;
            if (a == b) return true;
        }
        return false;
    }
}
