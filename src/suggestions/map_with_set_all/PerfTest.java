package suggestions.map_with_set_all;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import prng.XorShift32;

import java.util.Random;
import java.util.concurrent.TimeUnit;

//Benchmark              (n)  Mode  Cnt          Score           Error  Units
//PerfTest.getFast       100  avgt    5        670.371 ±       136.519  ns/op
//PerfTest.getFast      1000  avgt    5       8172.707 ±       420.222  ns/op
//PerfTest.getFast     10000  avgt    5     122153.199 ±      4563.889  ns/op
//PerfTest.getSlow       100  avgt    5        619.793 ±        73.434  ns/op
//PerfTest.getSlow      1000  avgt    5       6891.753 ±       411.608  ns/op
//PerfTest.getSlow     10000  avgt    5     111517.705 ±      6537.534  ns/op
//PerfTest.setAllFast    100  avgt    5        802.536 ±       101.380  ns/op
//PerfTest.setAllFast   1000  avgt    5       7795.616 ±       259.424  ns/op
//PerfTest.setAllFast  10000  avgt    5     134188.661 ±      6681.973  ns/op
//PerfTest.setAllSlow    100  avgt    5      27282.583 ±      2018.730  ns/op
//PerfTest.setAllSlow   1000  avgt    5    2610382.705 ±     19240.112  ns/op
//PerfTest.setAllSlow  10000  avgt    5  390856615.000 ± 422611146.128  ns/op

@SuppressWarnings("DefaultAnnotationParam")
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
public class PerfTest {
    @Param({"100", "1000", "10000"})
    private int n;

    private int seed;
    private XorShift32 xorShift32;

    private final MapSetAll<Integer, Integer> fast = new FastMap<>();
    private final MapSetAll<Integer, Integer> slow = new SlowMap<>();

    public static void main(String[] args) throws RunnerException {

        Options opt = new OptionsBuilder()
                .include(PerfTest.class.getCanonicalName())
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    public void getSlow(Blackhole bh) {
        testGet(slow, bh);
    }

    @Benchmark
    public void getFast(Blackhole bh) {
        testGet(fast, bh);
    }

    @Benchmark
    public void setAllSlow(Blackhole bh) {
        testSetAll(slow, bh);
    }

    @Benchmark
    public void setAllFast(Blackhole bh) {
        testSetAll(fast, bh);
    }


    private void testGet(MapSetAll<Integer, Integer> map, Blackhole bh) {
        xorShift32 = new XorShift32(seed);
        for (int i = 0; i < n; i++) {
            bh.consume(map.get(xorShift32.nextInteger()));
            xorShift32.nextInteger();
        }
    }

    private void testSetAll(MapSetAll<Integer, Integer> map, Blackhole bh) {
        xorShift32 = new XorShift32(seed);
        for (int i = 0; i < n; i++) {
            map.setAll(xorShift32.nextInteger());
            bh.consume(map.get(xorShift32.nextInteger()));
        }
    }

    @Setup
    public void setup() {
        Random rnd = new Random();
        this.seed = 0;
        while (seed == 0) seed = rnd.nextInt();
        this.xorShift32 = new XorShift32(seed);
        slow.clear();
        fast.clear();
        for (int i = 0; i < n; i++) {
            int key = xorShift32.nextInteger();
            int value = xorShift32.nextInteger();
            slow.put(key, value);
            fast.put(key, value);
        }
    }
}
