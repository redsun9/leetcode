package leetcode.leetcode6xx.leetcode690;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(x -> x.id, x -> x));
        return dfs(map, id);
    }

    private static int dfs(Map<Integer, Employee> map, int id) {
        Employee employee = map.get(id);
        int ans = employee.importance;
        ;
        if (employee.subordinates != null) {
            for (Integer subordinate : employee.subordinates) {
                ans += dfs(map, subordinate);
            }
        }
        return ans;
    }
}
