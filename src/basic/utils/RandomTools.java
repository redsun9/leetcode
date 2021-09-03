package basic.utils;

import java.util.Random;

public class RandomTools {
    // returns a random long uniformly from [0, n-1]
    public static long uniform(Random random, long n) {
        long r = random.nextLong();
        long m = n - 1;
        if ((n & m) == 0L) return r & m;
        long u = r >>> 1;
        while (u + m - (r = u % n) < 0L) u = random.nextLong() >>> 1;
        return r;
    }

    public static double gaussian(Random random, double mu, double sigma) {
        return mu + sigma * random.nextGaussian();
    }

    public static double poisson(Random random, double lambda) {
        int k = 0;
        double p = 1.0;
        double expLambda = Math.exp(-lambda);
        do {
            k++;
            p *= random.nextDouble();
        } while (p >= expLambda);
        return k - 1;
    }
}
