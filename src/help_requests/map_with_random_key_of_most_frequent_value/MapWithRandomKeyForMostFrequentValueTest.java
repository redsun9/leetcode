package help_requests.map_with_random_key_of_most_frequent_value;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class MapWithRandomKeyForMostFrequentValueTest {
    @Test
    void testPut() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.get("a"));
        assertEquals("d", map.get("c"));
        assertEquals("f", map.get("e"));
    }

    @Test
    void testPutReturnsOldValue() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.put("a", "g"));
        assertEquals("d", map.put("c", "h"));
        assertEquals("f", map.put("e", "i"));
    }

    @Test
    void testPutOverwritesOldValue() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
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
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
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
    void testRemove() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
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
    void testRemoveDoesNotRemoveOtherKeys() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.remove("a");
        assertEquals("d", map.get("c"));
    }

    @Test
    void testRemoveReturnsOldValue() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.remove("a"));
        assertEquals("d", map.remove("c"));
        assertEquals("f", map.remove("e"));
    }

    @Test
    void testRemoveReturnsNullIfKeyDoesNotExist() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertNull(map.remove("g"));
    }

    @Test
    void testGetMaxFrequency() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        assertEquals(0, map.getMaxFrequency());
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
    void testGetRandomKeyForMaxFrequency() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        assertNull(map.getRandomKeyWithMaxFrequency());
        map.put("a", "b");
        assertEquals("a", map.getRandomKeyWithMaxFrequency());
        map.put("c", "d");
        map.put("e", "f");

        // This test is not guaranteed to pass, but it is very likely to pass
        // if the implementation is correct.
        Set<String> expected = Set.of("a", "c", "e");
        Set<String> actual = new HashSet<>();
        for (int i = 0; i < 100; i++) actual.add(map.getRandomKeyWithMaxFrequency());
        assertEquals(expected, actual);
    }

    @Test
    void testGetRandomKeyForMaxFrequencyWithTwo() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "b");
        map.put("e", "f");
        map.put("g", "f");
        map.put("i", "h");

        Set<String> expected = Set.of("a", "c", "e", "g");
        Set<String> actual = new HashSet<>();
        for (int i = 0; i < 1000; i++) actual.add(map.getRandomKeyWithMaxFrequency());
        assertEquals(expected, actual);
    }

    @Test
    void testGetRandomKeyForMaxFrequencyWithTwoAfterDelete() {
        MapWithRandomKeyForMostFrequentValue<String, String> map = new MapWithRandomKeyForMostFrequentValue<>();
        map.put("a", "b");
        map.put("c", "b");
        map.put("e", "f");
        map.put("g", "f");
        map.put("i", "h");
        map.put("k", "h");
        map.remove("k");

        Set<String> expected = Set.of("a", "c", "e", "g");
        Set<String> actual = new HashSet<>();
        for (int i = 0; i < 1000; i++) actual.add(map.getRandomKeyWithMaxFrequency());
        assertEquals(expected, actual);
    }
}