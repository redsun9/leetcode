package leetcode.leetcode18xx.leetcode1896;

public class Solution {
    public int minOperationsToFlip(String expression) {
        return new Parser(expression).parse().minFlips;
    }

    private static class Parser {
        int cur, n;
        String s;

        Parser(String s) {
            this.s = s;
            this.cur = 0;
            this.n = s.length();
        }

        Node parse() {
            Node node = factor();
            while (cur < n && (s.charAt(cur) == '|' || s.charAt(cur) == '&')) {
                if (s.charAt(cur++) == '|') node = or(node, factor());
                else node = and(node, factor());
            }
            return node;
        }

        Node factor() {
            if (s.charAt(cur) == '(') {
                cur++;
                Node node = parse();
                cur++;
                return node;
            }
            return number();
        }

        Node number() {
            return new Node(s.charAt(cur++) == '1', 1);
        }

        Node or(Node node1, Node node2) {
            if (node1.val && node2.val) return new Node(true, 1 + Math.min(node1.minFlips, node2.minFlips));
            else if (node1.val || node2.val) return new Node(true, 1);
            else return new Node(false, Math.min(node1.minFlips, node2.minFlips));
        }

        Node and(Node node1, Node node2) {
            if (node1.val && node2.val) return new Node(true, Math.min(node1.minFlips, node2.minFlips));
            else if (node1.val || node2.val) return new Node(false, 1);
            else return new Node(false, 1 + Math.min(node1.minFlips, node2.minFlips));
        }
    }

    private record Node(boolean val, int minFlips) {
    }
}
