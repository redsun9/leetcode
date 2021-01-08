package leetcode.leetcode12xx.leetcode1203;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static final int[] EMPTY_RESPONSE = new int[0];

    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int totalNumberOfGroups = 0;
        Map<Integer, Integer> groupIdMap = new HashMap<>(); //parameter id to given id
        List<List<Integer>> memberOfGroups = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (group[i] == -1) {
                group[i] = totalNumberOfGroups++;
                memberOfGroups.add(Collections.singletonList(i));
            } else {
                Integer id = groupIdMap.get(group[i]);
                List<Integer> memberOfGroup;
                if (id == null) {
                    id = totalNumberOfGroups++;
                    groupIdMap.put(group[i], id);
                    memberOfGroup = new ArrayList<>();
                    memberOfGroups.add(memberOfGroup);
                } else {
                    memberOfGroup = memberOfGroups.get(id);
                }
                memberOfGroup.add(i);
                group[i] = id;
            }
        }
        int[] ans = new int[n];
        int pos = 0;
        Boolean[] markedElement = new Boolean[n];
        Boolean[] markedGroup = new Boolean[totalNumberOfGroups];
        Stack<Pair> groupStack = new Stack<>();
        Stack<Pair> memberStack = new Stack<>();
        for (int groupId = 0; groupId < totalNumberOfGroups; groupId++) groupStack.push(new Pair(groupId, false));
        while (!groupStack.isEmpty()) {
            Pair groupPair = groupStack.pop();
            int groupId = groupPair.argument;
            if (markedGroup[groupId] == null) {
                markedGroup[groupId] = false;
                groupStack.push(new Pair(groupId, true));
                for (Integer member : memberOfGroups.get(groupId)) {
                    for (Integer prev : beforeItems.get(member)) {
                        if (group[prev] != groupId) groupStack.push(new Pair(group[prev], false));
                    }
                }
            } else if (!markedGroup[groupId]) {
                if (!groupPair.afterRecursion) return EMPTY_RESPONSE;
                markedGroup[groupId] = true;
                for (Integer memberId : memberOfGroups.get(groupId)) memberStack.push(new Pair(memberId, false));
                while (!memberStack.isEmpty()) {
                    Pair memberPair = memberStack.pop();
                    int memberId = memberPair.argument;
                    if (markedElement[memberId] == null) {
                        markedElement[memberId] = false;
                        memberStack.push(new Pair(memberId, true));
                        for (Integer prev : beforeItems.get(memberId)) {
                            if (group[prev] == groupId) memberStack.push(new Pair(prev, false));
                        }
                    } else if (!markedElement[memberId]) {
                        if (!memberPair.afterRecursion) return EMPTY_RESPONSE;
                        markedElement[memberId] = true;
                        ans[pos++] = memberId;
                    }
                }
            }
        }
        return ans;
    }

    private static class Pair {
        final int argument;
        final boolean afterRecursion;

        public Pair(int argument, boolean afterRecursion) {
            this.argument = argument;
            this.afterRecursion = afterRecursion;
        }
    }
}
