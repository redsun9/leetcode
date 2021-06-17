package leetcode.leetcode7xx.leetcode707;

public class MyLinkedList {
    private final Node head;
    private final Node tail;
    private int size;

    public MyLinkedList() {
        size = 0;
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("h");
        Node tmp = head.next;
        while (tmp != tail) {
            sb.append("->").append(tmp.val);
            tmp = tmp.next;
        }
        return sb.toString();
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        return getPosition(index).val;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) return;
        if (index == 0) addAtHead(val);
        else if (index == size) addAtTail(val);
        else {
            Node oldNode = getPosition(index);
            Node newNode = new Node(val);
            newNode.prev = oldNode.prev;
            oldNode.prev.next = newNode;
            newNode.next = oldNode;
            oldNode.prev = newNode;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        Node oldNode = getPosition(index);
        oldNode.prev.next = oldNode.next;
        oldNode.next.prev = oldNode.prev;
        size--;
    }

    private Node getPosition(int pos) {
        if (pos <= size - pos) {
            Node tmp = head;
            while (pos-- >= 0) tmp = tmp.next;
            return tmp;
        } else {
            pos = size - pos - 1;
            Node tmp = tail;
            while (pos-- >= 0) tmp = tmp.prev;
            return tmp;
        }
    }

    private static class Node {
        final int val;
        Node next, prev;

        public Node(int val) {
            this.val = val;
        }
    }
}
