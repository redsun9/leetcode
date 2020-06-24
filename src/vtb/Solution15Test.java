package vtb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution15Test {

    @Test
    void removeDuplicates() {
        assertEquals("aa", Solution15.removeDuplicates("ddbbbdaa", 3));
    }
}