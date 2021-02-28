package raiffeisen.day4;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerfTest {
    PrimeTester[] primeTesters1 = {
            new PrimeTester1(),
            new PrimeTester2(),
            new PrimeTester3(),
            new PrimeTester4(),
            new PrimeTester5(10)
    };
    PrimeTester[] primeTesters2 = {
            new PrimeTester2(),
            new PrimeTester3(),
            new PrimeTester5(10)
    };

    @Test
    void checkCorrectness() {
        for (int i = 2; i <= 1_000_000; i++) {
            boolean prime = primeTesters1[0].isPrime(i);
            for (int j = 1; j < primeTesters1.length; j++) {
                try {
                    assertEquals(prime, primeTesters1[j].isPrime(i));
                } catch (Throwable e) {
                    System.out.println(i);
                    throw e;
                }
            }
        }
    }

    @Test
    void checkCorrectness2() {
        IntStream.rangeClosed(2, Integer.MAX_VALUE).parallel()
                .forEach(i -> {
                    boolean prime = primeTesters2[0].isPrime(i);
                    for (int j = 1; j < primeTesters2.length; j++) {
                        try {
                            assertEquals(prime, primeTesters2[j].isPrime(i));
                        } catch (Throwable e) {
                            System.out.println(i);
                            throw e;
                        }
                    }
                });
    }

    @Test
    void perfTest() {
        for (PrimeTester primeTester : primeTesters1) {
            long startTime = System.nanoTime();
            for (int i = 2; i <= 1_000_000; i++) {
                primeTester.isPrime(i);
            }
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }

    @Test
    void perfTest2() {
        for (PrimeTester primeTester : primeTesters2) {
            long startTime = System.nanoTime();
            long count = IntStream.rangeClosed(2, Integer.MAX_VALUE).parallel()
                    .filter(primeTester::isPrime).count();
            long endTime = System.nanoTime();
            System.out.println(count);
            System.out.println(endTime - startTime);
            System.out.println();
        }
    }

    @Test
    void perfTest3() {
        for (int i = 4; i <= 20; i++) {
            PrimeTester5 primeTester = new PrimeTester5(i);
            long startTime = System.nanoTime();
            long count = IntStream.rangeClosed(2, Integer.MAX_VALUE).parallel()
                    .filter(primeTester::isPrime).count();
            long endTime = System.nanoTime();
            System.out.println(count);
            System.out.println(endTime - startTime);
            System.out.println();
        }
    }
}
