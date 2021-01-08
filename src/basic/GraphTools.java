package basic;

import java.util.List;
import java.util.Stack;

public class GraphTools {
    public static int[] topologicalSortIn(List<List<Integer>> from) {
        int n = from.size();
        Boolean[] markedElement = new Boolean[n];
        int[] ans = new int[n];
        int pos = 0;
        Stack<Pair> memberStack = new Stack<>();
        for (int i = 0; i < n; i++) memberStack.push(new Pair(i, false));
        while (!memberStack.isEmpty()) {
            Pair memberPair = memberStack.pop();
            int memberId = memberPair.argument;
            if (markedElement[memberId] == null) {
                markedElement[memberId] = false;
                memberStack.push(new Pair(memberId, true));
                for (Integer prev : from.get(memberId)) {
                    memberStack.push(new Pair(prev, false));
                }
            } else if (!markedElement[memberId]) {
                if (!memberPair.afterRecursion) return null;
                markedElement[memberId] = true;
                ans[pos++] = memberId;
            }
        }
        return ans;
    }

    public static int[] topologicalSortOut(List<List<Integer>> to) {
        int n = to.size();
        Boolean[] markedElement = new Boolean[n];
        int[] ans = new int[n];
        int pos = n - 1;
        Stack<Pair> memberStack = new Stack<>();
        for (int i = 0; i < n; i++) memberStack.push(new Pair(i, false));
        while (!memberStack.isEmpty()) {
            Pair memberPair = memberStack.pop();
            int memberId = memberPair.argument;
            if (markedElement[memberId] == null) {
                markedElement[memberId] = false;
                memberStack.push(new Pair(memberId, true));
                for (Integer prev : to.get(memberId)) {
                    memberStack.push(new Pair(prev, false));
                }
            } else if (!markedElement[memberId]) {
                if (!memberPair.afterRecursion) return null;
                markedElement[memberId] = true;
                ans[pos--] = memberId;
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
