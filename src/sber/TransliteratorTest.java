package sber;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TransliteratorTest {
    private static final Map<Character, Character> TRANSLIT_CHARS1 = new HashMap<>() {{
        put('A', 'А');
        put('B', 'В');
        put('C', 'С');
        put('E', 'Е');
        put('K', 'К');
        put('M', 'М');
        put('H', 'Н');
        put('O', 'О');
        put('T', 'Т');
        put('P', 'Р');
        put('X', 'Х');
    }};
    private static final Map<Character, Character> TRANSLIT_CHARS2 = new HashMap<>() {{
        put('A', 'А');
        put('B', 'В');
        put('C', 'С');
        put('E', 'Е');
        put('K', 'К');
        put('M', 'М');
        put('H', 'Н');
        put('O', 'О');
        put('T', 'Т');
        put('P', 'Р');
        put('X', 'Х');
    }};

    @Test
    void test1() {
        Set<String> expected = Set.of("ADB", "ADВ", "АDB", "АDВ");
        assertEquals(expected, new HashSet<>(new Transliterator().getPossibleTransliterations("ADB", TRANSLIT_CHARS1)));
        assertEquals(expected, new HashSet<>(new Transliterator().getPossibleTransliterations("ADB", TRANSLIT_CHARS2)));
    }
}