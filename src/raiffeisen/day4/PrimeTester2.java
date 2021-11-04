package raiffeisen.day4;

import java.math.BigInteger;

/*
    support numbers from 1 to Integer>MAX_VALUE
    Probable primality test using BigInteger primality test

    still can very rarely give false positive results
    certainty can be increased/decreased
 */
public class PrimeTester2 implements PrimeTester {
    private static final int certainty = 20;

    @Override
    public boolean isPrime(int n) {
        return BigInteger.valueOf(n).isProbablePrime(certainty);
    }
}
