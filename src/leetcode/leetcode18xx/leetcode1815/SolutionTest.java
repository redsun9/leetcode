package leetcode.leetcode18xx.leetcode1815;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        int[] groups = {1, 2, 3, 4, 5, 6};
        assertEquals(4, new Solution().maxHappyGroups(3, groups));
    }

    @Test
    void test2() {
        int[] groups = {1, 3, 2, 5, 2, 2, 1, 6};
        assertEquals(4, new Solution().maxHappyGroups(4, groups));
    }

    @Test
    void test3() {
        int[] groups = {
                427131612, 605667633, 430658688, 184870663, 657607733, 95828484, 250750555, 521834986,
                8028559, 190673048, 567689172, 340635609, 537836866, 958889391, 696686201, 988310133,
                470639242, 998695730, 737137861, 686240045, 785358340, 242376365, 255952863
        };
        assertEquals(13, new Solution().maxHappyGroups(6, groups));
    }
}