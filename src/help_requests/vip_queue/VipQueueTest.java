package help_requests.vip_queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class VipQueueTest {
    @org.junit.jupiter.api.Test
    void test1() {
        VipQueue vipQueue = new VipQueue();
        vipQueue.add("1", true); // [1]
        vipQueue.add("2", true); // [1, 2]
        vipQueue.add("3", true); // [1, 3, 2]
        vipQueue.add("4", true); // [1, 3, 4, 2]
        assertEquals("1", vipQueue.get()); // [3, 4, 2]
        assertEquals("3", vipQueue.get()); // [4, 2]
        assertEquals("4", vipQueue.get()); // [2]
        assertEquals("2", vipQueue.get()); // []
        assertNull(vipQueue.get()); // []
    }

    @org.junit.jupiter.api.Test
    void test2() {
        VipQueue vipQueue = new VipQueue();
        vipQueue.add("1", true); // [1]
        vipQueue.add("2", true); // [1, 2]
        vipQueue.add("3", true); // [1, 3, 2]
        assertEquals("1", vipQueue.get()); // [3, 2]
        vipQueue.add("4", true); // [3, 4, 2]
        vipQueue.add("5", true); // [3, 4, 5, 2]
        assertEquals("3", vipQueue.get()); // [4, 5, 2]
        assertEquals("4", vipQueue.get()); // [5, 2]
        vipQueue.add("6", false); // [5, 2, 6]
        assertEquals("5", vipQueue.get()); // [2, 6]
        assertEquals("2", vipQueue.get()); // [2]
    }
}