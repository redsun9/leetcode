package atcoder.abc157;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProblemETest {

    @Test
    void testE() {
        ProblemE.Fenwick fenwick = new ProblemE.Fenwick("abcdbbd");
        assertEquals(4, fenwick.numberOfDifferentChars(1, 7));
        assertEquals(3, fenwick.numberOfDifferentChars(3, 6));
        fenwick.change(5, 'z');
        assertEquals(1, fenwick.numberOfDifferentChars(1, 1));
        fenwick.change(4, 'a');
        fenwick.change(7, 'd');
        assertEquals(5, fenwick.numberOfDifferentChars(1, 7));
        fenwick.change(3, 'a');
        assertEquals(4, fenwick.numberOfDifferentChars(1, 7));
    }
}