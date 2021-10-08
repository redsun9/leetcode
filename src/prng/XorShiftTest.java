package prng;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class XorShiftTest {
    @Test
    void testXorShift8() {
        XorShift8 fast = new XorShift8((byte) 1);
        XorShift8 slow = new XorShift8((byte) 1);
        long period = 1;
        while (true) {
            fast.nextByte();
            if (fast.nextByte() == slow.nextByte()) break;
            period++;
        }
        assertEquals((1L << 8) - 1, period);
    }

    @Test
    void testXorShift16() {
        XorShift16 fast = new XorShift16((short) 1);
        XorShift16 slow = new XorShift16((short) 1);
        long period = 1;
        while (true) {
            fast.nextShort();
            if (fast.nextShort() == slow.nextShort()) break;
            period++;
        }
        assertEquals((1L << 16) - 1, period);
    }

    @Test
    @Disabled
    void testXorShift32() {
        XorShift32 fast = new XorShift32(1);
        XorShift32 slow = new XorShift32(1);
        long period = 1;
        while (true) {
            fast.nextInteger();
            if (fast.nextInteger() == slow.nextInteger()) break;
            period++;
        }
        assertEquals((1L << 32) - 1, period);
    }

    @Test
    void testLowXorShiftN() {
        IntStream.rangeClosed(4, 16).parallel().forEach(bits -> {
            XorShiftN fast = new XorShiftN(1, bits);
            XorShiftN slow = new XorShiftN(1, bits);
            long period = 1;
            while (true) {
                fast.nextInteger();
                if (fast.nextInteger() == slow.nextInteger()) break;
                period++;
            }
            assertEquals((1L << bits) - 1, period);
        });
    }

    @Test
    @Disabled
    void testHighXorShiftN() {
        IntStream.rangeClosed(17, 31).parallel().forEach(bits -> {
            XorShiftN fast = new XorShiftN(1, bits);
            XorShiftN slow = new XorShiftN(1, bits);
            long period = 1;
            while (true) {
                fast.nextInteger();
                if (fast.nextInteger() == slow.nextInteger()) break;
                period++;
            }
            assertEquals((1L << bits) - 1, period);
        });
    }

    @Test
    @Disabled
    void findParameters() throws IOException {
        try (
                FileOutputStream fos = new FileOutputStream("src/prng/output.txt");
                PrintStream ps = new PrintStream(fos)
        ) {
            Lock lock = new ReentrantLock();
            for (int bits = 4; bits <= 31; bits++) {
                int finalBits = bits;
                long size = 1L << finalBits;
                int totalVariants = (finalBits - 1) * (finalBits - 1) * (finalBits - 1);
                IntStream.range(0, totalVariants).parallel()
                        .filter(s -> {
                            int s1 = 1 + s % (finalBits - 1);
                            s /= (finalBits - 1);
                            int s2 = 1 + s % (finalBits - 1);
                            s /= (finalBits - 1);
                            int s3 = 1 + s;

                            XorShiftN fast = new XorShiftN(1, finalBits, s1, s2, s3);
                            XorShiftN slow = new XorShiftN(1, finalBits, s1, s2, s3);
                            long period = 1;
                            while (true) {
                                fast.nextInteger();
                                if (fast.nextInteger() == slow.nextInteger()) break;
                                period++;
                            }
                            return size - 1 == period;
                        }).limit(1).forEach(s -> {
                            int s1 = 1 + s % (finalBits - 1);
                            s /= (finalBits - 1);
                            int s2 = 1 + s % (finalBits - 1);
                            s /= (finalBits - 1);
                            int s3 = 1 + s;
                            lock.lock();
                            ps.format("{%d, %d, %d, %d},\n", finalBits, s1, s2, s3);
                            lock.unlock();
                        });
                System.out.println(finalBits);
            }
        }
    }
}