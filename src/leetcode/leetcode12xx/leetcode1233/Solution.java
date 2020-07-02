package leetcode.leetcode12xx.leetcode1233;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> removeSubfolders(String[] folders) {
        if (folders.length == 0) return Collections.emptyList();
        if (folders.length == 1) return Collections.singletonList(folders[0]);
        Arrays.sort(folders, Comparator.comparingInt(String::length));
        if (folders[0].equals("/")) return Collections.singletonList("/");
        List<String> answer = new LinkedList<>();
        HashSet<String> seen = new HashSet<>();
        for (String folder : folders) {
            int from = 1;
            boolean found = false;
            while (!found) {
                int index = folder.indexOf('/', from);
                if (index < 0) break;
                found = seen.contains(folder.substring(0, index));
                from = index + 1;
            }
            if (!found) {
                answer.add(folder);
                seen.add(folder);
            }
        }
        return answer;
    }
}
