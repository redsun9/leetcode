package leetcode.leetcode14xx.leetcode1436;

import java.util.HashSet;
import java.util.List;

public class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> out = new HashSet<>();
        HashSet<String> in = new HashSet<>();
        for (List<String> path : paths) {
            out.add(path.get(0));
            in.add(path.get(1));
        }
        for (String city : in) {
            if (!out.contains(city)) return city;
        }
        return null;
    }
}
