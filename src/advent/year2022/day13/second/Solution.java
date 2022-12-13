package advent.year2022.day13.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day13/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day13/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            List<Node> list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                Node a = parse(scanner.nextLine().trim());
                Node b = parse(scanner.nextLine().trim());
                scanner.nextLine();
                list.add(a);
                list.add(b);
            }
            Node first = new Node(List.of(new Node(List.of(new Node(2)))));
            list.add(first);
            Node second = new Node(List.of(new Node(List.of(new Node(6)))));
            list.add(second);
            list.sort(Solution::compare);
            int idx1 = 0, idx2 = 0;
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == first) idx1 = i;
                if (list.get(i) == second) idx2 = i;
            }
            int ans = (idx1 + 1) * (idx2 + 1);
            printer.println(ans);
        }
    }

    private static Node parse(String s) {
        Stack<Node> stack = new Stack<>();
        int i = 0, n = s.length();
        stack.push(new Node(new ArrayList<>()));
        while (i < n) {
            if (s.charAt(i) == '[') {
                stack.push(new Node(new ArrayList<>()));
                i++;
            } else if (s.charAt(i) == ']') {
                Node pop = stack.pop();
                stack.peek().nodes.add(pop);
                i++;
            } else {
                int num = 0;
                while (true) {
                    char c = s.charAt(i++);
                    if (c == ',') {
                        stack.peek().nodes.add(new Node(num));
                        break;
                    } else if (c == ']') {
                        stack.peek().nodes.add(new Node(num));
                        Node pop = stack.pop();
                        stack.peek().nodes.add(pop);
                        break;
                    } else num = num * 10 + c - '0';
                }
            }
        }
        return stack.peek();
    }

    private static int compare(Node a, Node b) {
        if (!a.list && !b.list) return a.val.compareTo(b.val);
        else if (a.list && b.list) {
            int m = a.nodes.size(), n = b.nodes.size(), min = Math.min(m, n);
            for (int i = 0; i < min; i++) {
                int compare = compare(a.nodes.get(i), b.nodes.get(i));
                if (compare != 0) return compare;
            }
            return m - n;
        } else if (a.list)
            return compare(a, new Node(List.of(new Node(b.val))));
        else
            return compare(new Node(List.of(new Node(a.val))), b);
    }


    private static class Node {
        final boolean list;
        final Integer val;
        final List<Node> nodes;

        public Node(int val) {
            list = false;
            this.val = val;
            this.nodes = null;
        }

        public Node(List<Node> nodes) {
            list = true;
            this.val = null;
            this.nodes = nodes;
        }
    }
}
