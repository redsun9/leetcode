package leetcode.leetcode11xx.leetcode1125;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void test1() {
        String[] skills = {"hkyodbbhr", "p", "biflxurxdvb", "x", "qq", "yhiwcn"};
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < skills.length; i++) {
            map.put(skills[i], i);
        }
        String[][] people = {{"yhiwcn"}, {}, {}, {}, {"biflxurxdvb", "yhiwcn"}, {"hkyodbbhr"}, {"hkyodbbhr", "p"}, {"hkyodbbhr"}, {}, {"yhiwcn"}, {"hkyodbbhr", "qq"}, {"qq"}, {"hkyodbbhr"}, {"yhiwcn"}, {}, {"biflxurxdvb"}, {}, {"hkyodbbhr"}, {"hkyodbbhr", "yhiwcn"}, {"yhiwcn"}, {"hkyodbbhr"}, {"hkyodbbhr", "p"}, {}, {}, {"hkyodbbhr"}, {"biflxurxdvb"}, {"qq", "yhiwcn"}, {"hkyodbbhr", "yhiwcn"}, {"hkyodbbhr"}, {}, {}, {"hkyodbbhr"}, {}, {"yhiwcn"}, {}, {"hkyodbbhr"}, {"yhiwcn"}, {"yhiwcn"}, {}, {}, {"hkyodbbhr", "yhiwcn"}, {"yhiwcn"}, {"yhiwcn"}, {}, {}, {}, {"yhiwcn"}, {}, {"yhiwcn"}, {"x"}, {"hkyodbbhr"}, {}, {}, {"yhiwcn"}, {}, {"biflxurxdvb"}, {}, {}, {"hkyodbbhr", "biflxurxdvb", "yhiwcn"}, {}};
        Solution solution = new Solution();
        List<List<String>> peopleList = Arrays.stream(people).map(Arrays::asList).collect(Collectors.toList());
        int[] ans = solution.smallestSufficientTeam(skills, peopleList);
        assertEquals(4, ans.length);
        Set<String> teamSkills = Arrays.stream(ans)
                .mapToObj(i -> people[i])
                .flatMap(Arrays::stream)
                .collect(Collectors.toSet());
        assertEquals(skills.length, teamSkills.size());
    }
}