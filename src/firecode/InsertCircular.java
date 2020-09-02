package firecode;

public class InsertCircular {
    public ListNode insertAtTail(ListNode head, int data) {
        if (head == null) {
            ListNode ans = new ListNode(data);
            ans.next = ans;
            return ans;
        }
        ListNode tmp = head;
        while (tmp.next != head) tmp = tmp.next;
        tmp.next = new ListNode(data);
        tmp.next.next = head;
        return head;
    }
}
