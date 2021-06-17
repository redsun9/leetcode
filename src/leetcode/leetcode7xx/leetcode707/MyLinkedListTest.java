package leetcode.leetcode7xx.leetcode707;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListTest {

    @Test
    void test1() {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1, 2);
        assertEquals(2, list.get(1));
        list.deleteAtIndex(1);
        assertEquals(3, list.get(1));
    }
}