package leetcode.leetcode14xx.leetcode1452;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        List<List<String>> favoriteCompanies =
                Arrays.asList(
                        Arrays.asList("leetcode", "google", "facebook"),
                        Arrays.asList("google", "microsoft"),
                        Arrays.asList("google", "facebook"),
                        Arrays.asList("google"),
                        Arrays.asList("amazon")
                );
        assertEquals(Arrays.asList(0, 1, 4), new Solution().peopleIndexes(favoriteCompanies));
    }
}