package stress;

import org.junit.platform.commons.util.StringUtils;
import prng.XorShift64;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.LongSupplier;
import java.util.function.Predicate;

@SuppressWarnings("DuplicatedCode")
public class StressTester {
    public static <T, S> boolean exactStressTest(
            Function<Long, T> generator,
            Function<T, S> expectedFunction,
            Function<T, S> actualFunction,
            int maxNumberOfTests,
            int maxFailedTests,
            int debugStep
    ) throws InterruptedException {
        XorShift64 random = new XorShift64(1L);
        List<Long> failedSeeds = stressTest(
                random::nextLong,
                seed -> {
                    T testData = generator.apply(seed);
                    S expected = expectedFunction.apply(testData);
                    S actual = actualFunction.apply(testData);
                    return Objects.deepEquals(expected, actual);
                },
                maxNumberOfTests, maxFailedTests, debugStep
        );

        for (Long seed : failedSeeds) {
            T testData = generator.apply(seed);
            S expected = expectedFunction.apply(testData);
            S actual = actualFunction.apply(testData);

            String dataString = StringUtils.nullSafeToString(testData);
            String expectedString = StringUtils.nullSafeToString(expected);
            String actualString = StringUtils.nullSafeToString(actual);

            System.out.println();
            System.out.println("seed = " + seed);
            System.out.println("data: " + dataString);
            System.out.println("Expected: " + expectedString);
            System.out.println("Actual: " + actualString);
        }

        return failedSeeds.isEmpty();
    }

    //don't print debug messages
    public static <T, S> boolean exactStressTest(
            Function<Long, T> generator,
            Function<T, S> expectedFunction,
            Function<T, S> actualFunction,
            int maxNumberOfTests,
            int maxFailedTests
    ) throws InterruptedException {
        return exactStressTest(generator, expectedFunction, actualFunction, maxNumberOfTests, maxFailedTests, 0);
    }

    public static <T, S> boolean exactStressTest(
            Function<Long, T> generator,
            Function<T, S> expectedFunction,
            Function<T, S> actualFunction,
            int maxNumberOfTests
    ) throws InterruptedException {
        return exactStressTest(generator, expectedFunction, actualFunction, maxNumberOfTests, 1);
    }

    //find one failed test
    public static <T, S> boolean exactStressTest(
            Function<Long, T> generator,
            Function<T, S> expectedFunction,
            Function<T, S> actualFunction
    ) throws InterruptedException {
        return exactStressTest(generator, expectedFunction, actualFunction, Integer.MAX_VALUE);
    }

    public static <T, S> boolean constructionStressTest(
            Function<Long, T> generator,
            Function<T, S> actualFunction,
            BiPredicate<T, S> validator,
            int maxNumberOfTests,
            int maxFailedTests,
            int debugStep
    ) throws InterruptedException {
        XorShift64 random = new XorShift64(1L);
        List<Long> failedSeeds = stressTest(
                random::nextLong,
                seed -> {
                    T testData = generator.apply(seed);
                    S actual = actualFunction.apply(testData);
                    return validator.test(testData, actual);
                },
                maxNumberOfTests, maxFailedTests, debugStep
        );

        for (Long seed : failedSeeds) {
            T testData = generator.apply(seed);
            S actual = actualFunction.apply(testData);

            String dataString = StringUtils.nullSafeToString(testData);
            String actualString = StringUtils.nullSafeToString(actual);

            System.out.println();
            System.out.println("seed = " + seed);
            System.out.println("data: " + dataString);
            System.out.println("Actual: " + actualString);
        }

        return failedSeeds.isEmpty();
    }

    //don't print debug messages
    public static <T, S> boolean constructionStressTest(
            Function<Long, T> generator,
            Function<T, S> actualFunction,
            BiPredicate<T, S> validator,
            int maxNumberOfTests,
            int maxFailedTests
    ) throws InterruptedException {
        return constructionStressTest(generator, actualFunction, validator, maxNumberOfTests, maxFailedTests, 0);
    }

    public static <T, S> boolean constructionStressTest(
            Function<Long, T> generator,
            Function<T, S> actualFunction,
            BiPredicate<T, S> validator,
            int maxNumberOfTests
    ) throws InterruptedException {
        return constructionStressTest(generator, actualFunction, validator, maxNumberOfTests, 1);
    }

    public static <T, S> boolean constructionStressTest(
            Function<Long, T> generator,
            Function<T, S> actualFunction,
            BiPredicate<T, S> validator
    ) throws InterruptedException {
        return constructionStressTest(generator, actualFunction, validator, Integer.MAX_VALUE);
    }

    private static List<Long> stressTest(
            LongSupplier seedGenerator,
            Predicate<Long> seedValidator,
            int maxNumberOfTests,
            int maxFailedTests,
            int debugStep
    ) throws InterruptedException {

        ExecutorService tpe = Executors.newWorkStealingPool();
        int total = 0, previousFinished = 0;

        AtomicInteger finished = new AtomicInteger(), failed = new AtomicInteger();
        Semaphore semaphore = new Semaphore(Runtime.getRuntime().availableProcessors() * 2);
        ConcurrentLinkedQueue<Long> failedSeeds = new ConcurrentLinkedQueue<>();

        while (failed.get() < maxFailedTests && total != maxNumberOfTests) {
            total++;
            long seed = seedGenerator.getAsLong();
            Runnable runnable = () -> {
                semaphore.release();
                try {
                    boolean test = seedValidator.test(seed);
                    if (!test) failedSeeds.offer(seed);
                    if (!test) failed.incrementAndGet();
                } catch (Throwable throwable) {
                    failedSeeds.offer(seed);
                    failed.incrementAndGet();
                } finally {
                    finished.incrementAndGet();
                }
            };

            semaphore.acquire();
            tpe.submit(runnable);

            if (debugStep != 0) {
                int nowFinished = finished.get();
                if (nowFinished / debugStep > previousFinished / debugStep) {
                    System.out.printf("total = %d, failed = %d\n", finished.get(), failed.get());
                    previousFinished = nowFinished;
                }
            }
        }

        try {
            while (finished.get() != maxNumberOfTests && failed.get() < maxFailedTests) {
                if (tpe.awaitTermination(1, TimeUnit.SECONDS)) break;
            }
            tpe.shutdown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (debugStep != 0 && total >= debugStep) System.out.println();
        if (failed.get() != 0) {
            System.out.println("Assertion failed!");
            System.out.printf("total = %d, failed = %d\n", finished.get(), failed.get());
        }
        return failedSeeds.stream().toList();
    }
}
