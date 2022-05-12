package suggestions.map_with_set_all;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapSetAllTest {
    @Test
    void testPut() {
        FastMap<Integer, String> map = new FastMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        assertEquals("one", map.get(1));
        assertEquals("two", map.get(2));
        assertEquals("three", map.get(3));
        assertEquals(3, map.size());
        assertNull(map.get(4));
    }

    @Test
    void testSetAll() {
        FastMap<Integer, String> map = new FastMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.setAll("three");

        assertEquals("three", map.get(1));
        assertEquals("three", map.get(2));
        assertNull(map.get(3));
        assertEquals(2, map.size());

        map.put(4, "four");
        assertEquals("three", map.get(1));
        assertEquals("three", map.get(2));
        assertNull(map.get(3));
        assertEquals("four", map.get(4));
        assertEquals(3, map.size());
    }

    @Test
    void testRemove() {
        FastMap<Integer, String> map = new FastMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.remove(2);

        assertEquals("one", map.get(1));
        assertNull(map.get(2));
        assertEquals("three", map.get(3));
        assertEquals(2, map.size());
        assertNull(map.get(4));
    }

    @Test
    void testClear() {
        FastMap<Integer, String> map = new FastMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.clear();

        assertNull(map.get(1));
        assertNull(map.get(2));
        assertNull(map.get(3));
        assertEquals(0, map.size());
        assertNull(map.get(4));
    }

    @Test
    void testContainsKey() {
        FastMap<Integer, String> map = new FastMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");

        assertTrue(map.containsKey(1));
        assertTrue(map.containsKey(2));
        assertTrue(map.containsKey(3));
        assertFalse(map.containsKey(4));
    }

    @Test
    void testContainsAfterRemove() {
        FastMap<Integer, String> map = new FastMap<>();
        map.put(1, "one");
        map.put(2, "two");
        map.put(3, "three");
        map.remove(2);

        assertTrue(map.containsKey(1));
        assertFalse(map.containsKey(2));
        assertTrue(map.containsKey(3));
        assertFalse(map.containsKey(4));
    }

    @Test
    void testEmpty() {
        FastMap<Integer, String> map = new FastMap<>();
        assertTrue(map.isEmpty());
        map.put(1, "one");
        assertFalse(map.isEmpty());
        map.clear();
        assertTrue(map.isEmpty());
    }

    @Test
    void testPerformancePut() {
        FastMap<Integer, String> map = new FastMap<>();
        for (int i = 0; i < 100000; i++) map.put(i, Integer.toString(i));
    }

    @Test
    void testPerformanceGet() {
        FastMap<Integer, Integer> map = new FastMap<>();
        for (int i = 0; i < 100000; i++) map.put(i, i * 2);
        long sum = 0;
        for (int i = 0; i < 100000; i++) sum += map.get(i);
        System.out.println(sum);
    }

}