package help_requests.map_with_most_frequency;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SuppressWarnings("DuplicatedCode")
class MapWithMostFrequencyTest {
    @Test
    void testPut() {
        MapWithMostFrequency<String, String> map = new MapWithMostFrequency<>();
        map.put("a", "b");
        map.put("c", "d");
        assertEquals("b", map.put("a", "e"));
        assertEquals("e", map.put("a", "e"));
        assertEquals("d", map.put("c", "d"));
        assertEquals("d", map.put("c", "f"));
        assertEquals("f", map.put("c", "f"));
    }

    @Test
    void testRemove() {
        MapWithMostFrequency<String, String> map = new MapWithMostFrequency<>();
        map.put("a", "b");
        map.put("c", "d");
        assertEquals("b", map.remove("a"));
        assertEquals("d", map.remove("c"));
        assertNull(map.remove("a"));
        assertNull(map.remove("c"));
    }

    @Test
    void testGetMaxFrequency() {
        MapWithMostFrequency<String, String> map = new MapWithMostFrequency<>();
        assertEquals(0, map.getMaxFrequency());

        map.put("a", "b");
        assertEquals(1, map.getMaxFrequency());

        map.put("c", "d");
        assertEquals(1, map.getMaxFrequency());

        map.put("e", "b");
        assertEquals(2, map.getMaxFrequency());

        map.put("f", "d");
        assertEquals(2, map.getMaxFrequency());

        map.remove("e");
        assertEquals(2, map.getMaxFrequency());

        map.remove("f");
        assertEquals(1, map.getMaxFrequency());
    }

    @Test
    void testGet() {
        MapWithMostFrequency<String, String> map = new MapWithMostFrequency<>();
        map.put("a", "b");
        map.put("c", "d");
        assertEquals("b", map.get("a"));
        assertEquals("d", map.get("c"));
        assertNull(map.get("e"));
    }
}