package vtb;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution22 {
    public static List<Integer> dailyTemperatures(List<Integer> t) {
        // Напишите ваш код здесь...
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = t.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && t.get(stack.peek()) <= t.get(i)) stack.pop();
            if (stack.isEmpty()) ans.addFirst(0);
            else ans.addFirst(stack.peek() - i);
            stack.push(i);
        }
        return ans;
    }
}
