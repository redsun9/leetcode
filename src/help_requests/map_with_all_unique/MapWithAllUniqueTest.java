package help_requests.map_with_all_unique;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapWithAllUniqueTest {
    @Test
    void testPut() {
        MapWithAllUnique<String, String> map = new MapWithAllUnique<>();
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
        MapWithAllUnique<String, String> map = new MapWithAllUnique<>();
        map.put("a", "b");
        map.put("c", "d");
        assertEquals("b", map.remove("a"));
        assertEquals("d", map.remove("c"));
        assertNull(map.remove("a"));
        assertNull(map.remove("c"));
    }

    @Test
    void testHasDuplicateValues() {
        MapWithAllUnique<String, String> map = new MapWithAllUnique<>();
        assertFalse(map.hasDuplicateValues());

        map.put("a", "b");
        assertFalse(map.hasDuplicateValues());

        map.put("c", "d");
        assertFalse(map.hasDuplicateValues());

        map.put("e", "b");
        assertTrue(map.hasDuplicateValues());

        map.put("f", "d");
        assertTrue(map.hasDuplicateValues());

        map.remove("e");
        assertTrue(map.hasDuplicateValues());

        map.remove("f");
        assertFalse(map.hasDuplicateValues());
    }

    @Test
    void testGet() {
        MapWithAllUnique<String, String> map = new MapWithAllUnique<>();
        map.put("a", "b");
        map.put("c", "d");
        assertEquals("b", map.get("a"));
        assertEquals("d", map.get("c"));
        assertNull(map.get("e"));
    }

    @Test
    void testPutNull() {
        MapWithAllUnique<String, String> map = new MapWithAllUnique<>();
        map.put("a", "b");
        map.put("c", "d");
        assertEquals("b", map.put("a", null));
        assertEquals("d", map.put("c", null));
        assertNull(map.put("a", null));
        assertNull(map.put("c", null));
    }

    @Test
    void testRemoveNull() {
        MapWithAllUnique<String, String> map = new MapWithAllUnique<>();
        map.put("a", "b");
        map.put("c", "d");
        assertNull(map.remove("e"));
        assertNull(map.remove("f"));
    }
}