package basic;

import basic.utils.ArrayTools;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxHeapTest {
    private static final int smallN = 10_000;
    private static final int bigN = 10_000_000;

    @Test
    void test1() {
        int[] a = new int[smallN];
        for (int i = 0; i < smallN; i++) {
            a[i] = i + 1;
        }
        ArrayTools.shuffle(a);
        MaxHeap maxHeap = new MaxHeap(a);
        for (int i = smallN; i >= 0; i--) {
            assertEquals(i, maxHeap.poll());
        }
    }

    @Test
    void test2() {
        int[] a = new int[smallN];
        for (int i = 0; i < smallN; i++) {
            a[i] = i + 1;
        }
        ArrayTools.shuffle(a);
        MaxHeap maxHeap = new MaxHeap();
        for (int i : a) {
            maxHeap.add(i);
        }

        for (int i = smallN; i >= 0; i--) {
            assertEquals(i, maxHeap.poll());
        }
    }

    @Test
    void testPerfAddingByOne() {
        int[] a = new int[smallN];
        for (int i = 0; i < smallN; i++) {
            a[i] = i + 1;
        }
        ArrayTools.shuffle(a);
        long startTime = System.nanoTime();
        MaxHeap maxHeap = new MaxHeap(smallN);
        for (int i : a) {
            maxHeap.add(i);
        }
        long endTime = System.nanoTime();
        maxHeap.poll();
        System.out.println("adding by adding by one - " + (endTime - startTime) / 1_000_000);
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testPerfCreatingWithArray() {
        int[] a = new int[bigN];
        for (int i = 0; i < bigN; i++) {
            a[i] = i + 1;
        }
        ArrayTools.shuffle(a);
        long startTime = System.nanoTime();
        MaxHeap maxHeap = new MaxHeap(a);
        long endTime = System.nanoTime();
        maxHeap.poll();
        System.out.println("creating by array - " + (endTime - startTime) / 1_000_000);
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testPerfPollFromRebalancing() {
        int[] a = new int[bigN];
        for (int i = 0; i < bigN; i++) {
            a[i] = i + 1;
        }
        ArrayTools.shuffle(a);
        MaxHeap maxHeap = new MaxHeap(a, true);
        long startTime = System.nanoTime();
        for (int i = bigN; i >= 0; i--) {
            assertEquals(i, maxHeap.poll());
        }
        long endTime = System.nanoTime();
        System.out.println("polling from rebalancing - " + (endTime - startTime) / 1_000_000);
    }

    @Test
    @org.junit.jupiter.api.Disabled
    void testPerfPollFromUnbalancing() {
        int[] a = new int[bigN];
        for (int i = 0; i < bigN; i++) {
            a[i] = i + 1;
        }
        ArrayTools.shuffle(a);
        MaxHeap maxHeap = new MaxHeap(a, false);
        long startTime = System.nanoTime();
        for (int i = bigN; i >= 0; i--) {
            assertEquals(i, maxHeap.poll());
        }
        long endTime = System.nanoTime();
        System.out.println("poliin from unbalancing" + (endTime - startTime) / 1_000_000);
    }
}