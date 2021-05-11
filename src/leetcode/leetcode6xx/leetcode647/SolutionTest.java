package leetcode.leetcode6xx.leetcode647;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void test1() {
        assertEquals(3, new Solution().countSubstrings("abc"));
        assertEquals(3, new Solution2().countSubstrings("abc"));
        assertEquals(3, new Solution3().countSubstrings("abc"));
    }

    @Test
    void test2() {
        assertEquals(6, new Solution().countSubstrings("aaa"));
        assertEquals(6, new Solution2().countSubstrings("aaa"));
        assertEquals(6, new Solution3().countSubstrings("aaa"));
    }

    @Test
    @Disabled
    void test3() {
        Random random = new Random(0);
        int numberOfTests = 100;
        int lengthOfTests = 10000;
        String[] tests = new String[numberOfTests];

        IntStream.range(0, numberOfTests).forEach(i -> {
            char[] str = new char[lengthOfTests];
            for (int j = 0; j < lengthOfTests; j++) {
                str[j] = (char) ('a' + random.nextInt(3));
            }
            tests[i] = new String(str);
        });
        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();
        Arrays.stream(tests).parallel().forEach(test -> {
            assertEquals(solution2.countSubstrings(test), solution3.countSubstrings(test));
        });
    }


    /*
        Cardinality = 2
        215067900
        648259000
        Cardinality = 3
        40803900
        191038500
        Cardinality = 4
        33949300
        77589000
        Cardinality = 5
        31849500
        69220000
     */
    @Test
    @org.junit.jupiter.api.Disabled
    void testPerfForCardinality() {
        Random random = new Random(0);
        int numberOfTests = 1000;
        int lengthOfTests = 100000;
        int minCardinality = 2;
        int maxCardinality = 5;
        String[] tests = new String[numberOfTests];

        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        for (int cardinality = minCardinality; cardinality <= maxCardinality; cardinality++) {
            int finalCardinality = cardinality;
            IntStream.range(0, numberOfTests).forEach(i -> {
                char[] str = new char[lengthOfTests];
                for (int j = 0; j < lengthOfTests; j++) {
                    str[j] = (char) ('a' + random.nextInt(finalCardinality));
                }
                tests[i] = new String(str);
            });

            System.out.println("Cardinality = " + cardinality);
            long startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertTrue(solution2.countSubstrings(test) > 0);
            });
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);

            startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertTrue(solution3.countSubstrings(test) > 0);
            });
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }

    /*
        Cardinality = 1.0E-4
        41240715500
        741315300
        Cardinality = 2.0E-4
        19302443700
        104783100
        Cardinality = 5.0E-4
        8006353500
        51769000
        Cardinality = 0.001
        4287051000
        48850100
        Cardinality = 0.002
        2162959200
        53552000
        Cardinality = 0.005
        892823400
        50846200
        Cardinality = 0.01
        447348900
        51007900
        Cardinality = 0.02
        232763800
        50476100
        Cardinality = 0.05
        97417600
        52543700
        Cardinality = 0.1
        55849700
        55653400
        Cardinality = 0.2
        37310200
        56218300
        Cardinality = 0.5
        29877500
        58070300
     */

    @Test
    @org.junit.jupiter.api.Disabled
    void testPerfForAB() {
        Random random = new Random(0);
        int numberOfTests = 1000;
        int lengthOfTests = 65535;
        double[] cardinalities = {0.0001, 0.0002, 0.0005, 0.001, 0.002, 0.005, 0.01, 0.02, 0.05, 0.1, 0.2, 0.5};
        String[] tests = new String[numberOfTests];

        Solution2 solution2 = new Solution2();
        Solution3 solution3 = new Solution3();

        for (double cardinality : cardinalities) {
            IntStream.range(0, numberOfTests).forEach(i -> {
                char[] str = new char[lengthOfTests];
                for (int j = 0; j < lengthOfTests; j++) {
                    str[j] = random.nextDouble() <= cardinality ? 'a' : 'b';
                }
                tests[i] = new String(str);
            });

            System.out.println("Cardinality = " + cardinality);
            long startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertTrue(solution2.countSubstrings(test) > 0);
            });
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);

            startTime = System.nanoTime();
            Arrays.stream(tests).parallel().forEach(test -> {
                assertTrue(solution3.countSubstrings(test) > 0);
            });
            endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }
}