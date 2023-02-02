package help_requests.map_with_random_most_frequent_value;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MapWithRandomMostFrequentValueTest {
    @Test
    void testPut() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.get("a"));
        assertEquals("d", map.get("c"));
        assertEquals("f", map.get("e"));
    }

    @Test
    void testPutReturnsOldValue() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.put("a", "g"));
        assertEquals("d", map.put("c", "h"));
        assertEquals("f", map.put("e", "i"));
    }

    @Test
    void testPutOverwritesOldValue() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        map.put("a", "g");
        map.put("c", "h");
        map.put("e", "i");
        assertEquals("g", map.get("a"));
        assertEquals("h", map.get("c"));
        assertEquals("i", map.get("e"));
    }

    @Test
    void testPutNullRemovesKey() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        map.put("a", null);
        map.put("c", null);
        map.put("e", null);
        assertNull(map.get("a"));
        assertNull(map.get("c"));
        assertNull(map.get("e"));
    }

    @Test
    void testPutNullReturnsOldValue() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.put("a", null));
        assertEquals("d", map.put("c", null));
        assertEquals("f", map.put("e", null));
    }

    @Test
    void testRemove() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        map.remove("a");
        map.remove("c");
        map.remove("e");
        assertNull(map.get("a"));
        assertNull(map.get("c"));
        assertNull(map.get("e"));
    }

    @Test
    void testRemoveReturnsOldValue() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.remove("a"));
        assertEquals("d", map.remove("c"));
        assertEquals("f", map.remove("e"));
    }

    @Test
    void testRemoveNull() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertNull(map.remove("b"));
        assertNull(map.remove("d"));
        assertNull(map.remove("f"));
    }

    @Test
    void testGetMaxFrequency() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        assertEquals(1, map.getMaxFrequency());
        map.put("c", "d");
        assertEquals(1, map.getMaxFrequency());
        map.put("e", "f");
        assertEquals(1, map.getMaxFrequency());
        map.put("g", "b");
        assertEquals(2, map.getMaxFrequency());
        map.put("h", "b");
        assertEquals(3, map.getMaxFrequency());
    }

    @Test
    void testGetRandomMaxFrequency() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "b");
        for (int i = 0; i < 100; i++) assertEquals("b", map.getRandomValueWithMaxFrequency());
    }

    @Test
    void testGetRandomMaxFrequencyWithMultipleMaxFrequencies() {
        MapWithRandomMostFrequentValue<String, String> map = new MapWithRandomMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "b");
        map.put("f", "d");
        map.put("g", "b");
        map.put("h", "d");
        map.put("i", "c");
        Set<String> expected = Set.of("b", "d");
        Set<String> actual = new HashSet<>();
        for (int i = 0; i < 100; i++) actual.add(map.getRandomValueWithMaxFrequency());
        assertEquals(expected, actual);
    }
}