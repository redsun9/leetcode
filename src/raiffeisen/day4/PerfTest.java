package raiffeisen.day4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PerfTest {
    @Test
    void checkCorrectness() {
        PrimeTester[] primeTesters = {
                new PrimeTester1(), new PrimeTester2(), new PrimeTester3(), new PrimeTester4()
        };
        for (int i = 2; i <= 1_000_000; i++) {
            boolean prime = primeTesters[0].isPrime(i);
            for (int j = 1; j < primeTesters.length; j++) {
                try {
                    assertEquals(prime, primeTesters[j].isPrime(i));
                } catch (Throwable e) {
                    System.out.println(i);
                    throw e;
                }
            }
        }
    }

    @Test
    void perfTest() {
        PrimeTester[] primeTesters = {new PrimeTester1(), new PrimeTester2(), new PrimeTester3(), new PrimeTester4()};
        for (PrimeTester primeTester : primeTesters) {
            long startTime = System.nanoTime();
            for (int i = 2; i <= 1_000_000; i++) {
                primeTester.isPrime(i);
            }
            long endTime = System.nanoTime();
            System.out.println(endTime - startTime);
        }
    }
}
