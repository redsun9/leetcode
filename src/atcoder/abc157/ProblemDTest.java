package atcoder.abc157;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProblemDTest {

    @Test
    void getNumberOfProposedFriends() {
        int[] numberOfProposedFriends = ProblemD.getNumberOfProposedFriends(
                new List[]{Arrays.asList(1, 2), Arrays.asList(0, 2), Arrays.asList(0, 1, 3), Collections.singletonList(2)},
                new List[]{Collections.singletonList(3), Collections.emptyList(), Collections.emptyList(), Collections.singletonList(0)}
        );
        System.out.println(Arrays.toString(numberOfProposedFriends));
        assertArrayEquals(new int[]{0, 1, 0, 1}, numberOfProposedFriends);
    }
}