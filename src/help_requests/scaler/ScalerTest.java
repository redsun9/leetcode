package help_requests.scaler;

import org.junit.jupiter.api.Test;
import prng.XorShift32;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ScalerTest {
    @Test
    void testRandom() {
        int numberOfTests = 10000;
        XorShift32 random = new XorShift32(1);
        for (int t = 0; t < numberOfTests; t++) {
            int key = random.nextInteger();

            // screen = w*h, videoRatio = rw*rh, scaled = sw*sh
            int w = key & 0xff, h = key >> 8 & 0xff;
            int rw = key >> 16 & 0xff, rh = key >> 24 & 0xff;
            if (rw == 0 && rh == 0) continue;

            int[] scaled = Scaler.scale(new int[]{w, h}, new int[]{rw, rh});
            int sw = scaled[0], sh = scaled[1];

            assertTrue(sw >= 0);
            assertTrue(sh >= 0);
            assertTrue(w >= sw && h >= sh); //scaled should fit in screen

            if (sw == 0 || sh == 0) continue;

            assertTrue(w == sw || h == sh); //at least one side is fit

            // there is no sw1: such that sw1/sh between (sw/sh, rw/rh)
            assertFalse(sw < w && (sw + 1) * rh - rw * sh < 0);
            assertFalse(sh == h && (sw - 1) * rh - rw * sh > 0);

            // there is no sh1: such that sw/sh1 between (sw/sh, rw/rh)
            assertFalse(sh < h && (sh + 1) * rw - rh * sw < 0);
            assertFalse(sw == w && (sh - 1) * rw - rh * sw > 0);
        }
    }
}