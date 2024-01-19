package codeforces.contest1883

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import org.openjdk.jmh.runner.Runner
import org.openjdk.jmh.runner.RunnerException
import org.openjdk.jmh.runner.options.OptionsBuilder
import java.util.concurrent.ThreadLocalRandom
import java.util.concurrent.TimeUnit
import java.util.stream.IntStream

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
@Warmup(iterations = 5, time = 1)
@Measurement(iterations = 5, time = 1)
class PerfTestF {
    @Param("100", "1000", "10000", "100000", "1000000")
    private var n = 0

    private val batchSize = 100
    private val tests = arrayOfNulls<IntArray>(batchSize)

    @Benchmark
    fun sol1(bh: Blackhole) {
        for (test in tests) {
            bh.consume(solve(test!!));
        }
    }

    @Benchmark
    fun sol2(bh: Blackhole) {
        for (test in tests) {
            bh.consume(solve2(test!!));
        }
    }

    @Setup
    fun setup() {
        IntStream.range(0, batchSize).parallel().forEach { t ->
            val random = ThreadLocalRandom.current()
            tests[t] = IntArray(n) { random.nextInt() }
        }
    }
}

@Throws(RunnerException::class)
fun main(args: Array<String>) {
    val opt = OptionsBuilder()
        .include(PerfTestF::class.java.canonicalName)
        .forks(1)
        .build()

    Runner(opt).run()
}
