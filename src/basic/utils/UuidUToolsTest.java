package basic.utils;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class UuidUToolsTest {

    @Test
    void testCorrectnessLower() {
        String regex = "^[0-9a-f]{12}[4][0-9a-f]{3}[89ab][0-9a-f]{15}$";
        Pattern pattern = Pattern.compile(regex);
        Predicate<String> predicate = pattern.asPredicate();
        assertTrue(
                IntStream.range(0, 1_000_000).parallel()
                        .allMatch(i -> predicate.test(UuidUTools.getRandomUuidWithoutDashesLower()))
        );
    }

    @Test
    void testCorrectnessUpper() {
        String regex = "^[0-9A-F]{12}[4][0-9A-F]{3}[89AB][0-9A-F]{15}$";
        Pattern pattern = Pattern.compile(regex);
        Predicate<String> predicate = pattern.asPredicate();
        assertTrue(
                IntStream.range(0, 1_000_000).parallel()
                        .allMatch(i -> predicate.test(UuidUTools.getRandomUuidWithoutDashesUpper()))
        );
    }


}