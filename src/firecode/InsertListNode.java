package firecode;

public class InsertListNode {
    public ListNode insertAtPosition(ListNode head, int data, int pos) {
        ListNode newNode = new ListNode(data);
        ListNode ans = new ListNode(0);
        ListNode tmp = ans;
        tmp.next = head;
        while (--pos != 0 && tmp.next != null) tmp = tmp.next;
        newNode.next = tmp.next;
        tmp.next = newNode;
        return ans.next;
    }
}
