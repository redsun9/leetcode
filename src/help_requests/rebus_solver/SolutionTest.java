package help_requests.rebus_solver;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] operands = {"кошка", "кошка", "кошка"};
        String result = "собака";
        Set<String> expected = Set.of("56350 + 56350 + 56350 = 169050", "57350 + 57350 + 57350 = 172050");
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.ADDITION));
        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        String[] operands = {"СИНУС", "СИНУС", "КОСИНУС"};
        String result = "ТАНГЕНС";
        Set<String> expected = Set.of("58725 + 58725 + 3958725 = 4076175");
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.ADDITION));
        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        String[] operands = {"ДВА", "ДВА"};
        String result = "ЧЕТЫРЕ";
        Set<String> expected = Set.of("459 * 459 = 210681");
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.MULTIPLICATION));
        assertEquals(expected, actual);
    }

    @Test
    void test4() {
        String[] operands = {"DONALD", "GERALD"};
        String result = "ROBERT";
        Set<String> expected = Set.of("526485 + 197485 = 723970");
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.ADDITION));
        assertEquals(expected, actual);
    }

    @Test
    void test5() {
        String[] operands = {"БАБКА", "ДЕДКА", "РЕПКА"};
        String result = "СКАЗКА";
        Set<String> expected = Set.of(
                "90950 + 74750 + 84650 = 250350",
                "80850 + 94950 + 74350 = 250150",
                "90950 + 84850 + 74350 = 250150",
                "70750 + 94950 + 84650 = 250350"
        );
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.ADDITION));
        System.out.println(actual);
        assertEquals(expected, actual);
    }

    @Test
    void test6() {
        String[] operands = {"ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ"};
        String result = "РУБЛЬ";
        Set<String> expected = Set.of("15645 + 15645 + 15645 + 15645 + 15645 + 15645 = 93870");
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.ADDITION));
        assertEquals(expected, actual);
    }

    @Test
    void test7() {
        String[] operands = {"ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ", "ТЕНГЕ"};
        String result = "РУБЛЬ";
        Set<String> expected = Set.of("12562 + 12562 + 12562 + 12562 + 12562 + 12562 + 12562 = 87934");
        Set<String> actual = new HashSet<>(Solution.solve(operands, result, Solution.Operation.ADDITION));
        assertEquals(expected, actual);
    }
}