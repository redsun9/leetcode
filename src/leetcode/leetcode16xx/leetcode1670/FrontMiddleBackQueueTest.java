package leetcode.leetcode16xx.leetcode1670;

import org.junit.jupiter.api.Test;

import java.util.function.IntConsumer;
import java.util.function.IntSupplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FrontMiddleBackQueueTest {

    @Test
    void pushPop() {
        FrontMiddleBackQueue queue = new FrontMiddleBackQueue();
        IntConsumer[] consumers = {
                queue::pushMiddle,
                queue::pushFront,
                queue::pushBack
        };

        IntSupplier[] suppliers = {
                queue::popBack,
                queue::popFront,
                queue::popMiddle
        };
        for (int i = 0; i < consumers.length; i++) {
            IntConsumer consumer = consumers[i];
            for (int j = 0; j < suppliers.length; j++) {
                IntSupplier supplier = suppliers[j];
                consumer.accept(10);
                try {
                    assertEquals(10, supplier.getAsInt());
                } catch (Throwable throwable) {
                    System.out.println(i + " " + j);
                }
            }
        }
    }
}