package leetcode.leetcode3xx.leetcode394;

import java.util.Stack;

public class Solution {
    public String decodeString(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();
        Stack<StackElement> elements = new Stack<>();
        int n = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                if (sb.length() != 0) {
                    strStack.push(sb.toString());
                    elements.push(StackElement.STRING);
                    sb = new StringBuilder();
                }
                n = n * 10 + c - '0';
            } else if (c == '[') {
                if (n > 0) {
                    intStack.push(n);
                    elements.push(StackElement.NUMBER);
                    n = 0;
                }
                elements.push(StackElement.OPEN_BRACKET);
            } else if (c == ']') {
                while (!elements.isEmpty() && elements.peek().equals(StackElement.STRING)) {
                    elements.pop();
                    sb.insert(0, strStack.pop());
                }
                elements.pop();//open_bracket
                elements.pop();//numer
                int k = intStack.pop();
                String str = sb.toString();
                while (k-- > 1) sb.append(str);
                elements.push(StackElement.STRING);
                strStack.push(sb.toString());
                sb = new StringBuilder();
            } else sb.append(c);
        }
        while (!strStack.isEmpty()) sb.insert(0, strStack.pop());
        return sb.toString();
    }

    enum StackElement {
        NUMBER,
        STRING,
        OPEN_BRACKET,
        CLOSE_BRACKET
    }
}
