package help_requests.map_with_random_key_for_value;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MapWithRandomKeyForValueTest {
    @Test
    void testPut() {
        MapWithRandomKeyForValue<String, String> map = new MapWithRandomKeyForValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "f");
        assertEquals("b", map.get("a"));
        assertEquals("d", map.get("c"));
        assertEquals("f", map.get("e"));
    }

    @Test
    void testGetRandomKeyForValue() {
        MapWithRandomKeyForValue<String, String> map = new MapWithRandomKeyForValue<>();
        map.put("a", "b");
        map.put("c", "d");
        map.put("e", "b");

        Set<String> expected = Set.of("a", "e");
        Set<String> actual = new HashSet<>();
        for (int i = 0; i < 100; i++) actual.add(map.getRandomKeyForValue("b"));
        assertEquals(expected, actual);

        map.remove("a");
        for (int i = 0; i < 100; i++) assertEquals("e", map.getRandomKeyForValue("b"));
    }
}