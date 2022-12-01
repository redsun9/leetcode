package advent.year2021.day18.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final int reduceFromLevel = 4;
    private static final int splitFromValue = 10;

    private static PrintStream printer;
    private static final boolean debug = false;


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day18/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day18/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Solution.printer = printer;
            List<ParserResult> nodes = new ArrayList<>();
            while (scanner.hasNextLine()) {
                ParserResult parserResult = new Parser(scanner.nextLine().trim()).parse();
                if (debug) printDebug(parserResult);
                nodes.add(parserResult);
            }
            int n = nodes.size();
            long max = 0;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) continue;
                    ParserResult u = nodes.get(i), v = nodes.get(j);
                    u.maxRight.next = v.maxLeft;
                    v.maxLeft.prev = u.maxRight;

                    SnailfishNumber node = new SnailfishNumber(u.node, v.node);
                    SnailfishNumber cloned = cloneTree(node);

                    u.maxRight.next = null;
                    v.maxLeft.prev = null;
                    reduce(cloned);
                    long score = cloned.score();
                    max = Math.max(max, score);
                }
            }
            printer.println(max);
        }
    }

    private static SnailfishNumber cloneTree(SnailfishNumber root) {
        firstStep(root);
        SnailfishNumber ans = root.left;
        secondStep(root);
        thirdStep(root);
        return ans;
    }

    //a,l,r -> (a,a',r),(a,l,r)
    private static void firstStep(SnailfishNumber root) {
        if (root == null) return;
        SnailfishNumber copy = new SnailfishNumber(root.leaf, root.val);
        copy.left = root.left;
        copy.right = root.right;
        root.left = copy;
        firstStep(copy.left);
        firstStep(copy.right);
    }

    //set next,prev for copies
    private static void secondStep(SnailfishNumber root) {
        if (root == null) return;
        if (root.next != null) root.left.next = root.next.left;
        if (root.prev != null) root.left.prev = root.prev.left;
        secondStep(root.left.left);
        secondStep(root.left.right);
    }

    private static void thirdStep(SnailfishNumber root) {
        if (root == null) return;
        SnailfishNumber left = root.left.left;
        root.left.left = left != null ? left.left : null;
        root.left.right = root.right != null ? root.right.left : null;
        root.left = left;
        thirdStep(root.left);
        thirdStep(root.right);
    }

    private static void printDebug(ParserResult x) {
        printer.println("x = " + x.node);
        printer.println(x.maxLeft.getNextLinks());
        printer.println(x.maxRight.getPrevLinks());
        printer.println();
    }

    private static void reduce(SnailfishNumber x) {
        while (true) {
            if (tryExplode(x, 0)) continue;
            if (trySplit(x, 0)) continue;
            break;
        }
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean tryExplode(SnailfishNumber node, int level) {
        if (node.leaf) return false;
        if (level >= reduceFromLevel && node.left.leaf && node.right.leaf) {
            if (debug) printer.println("reduced " + node.left.val + " " + node.right.val + " on level " + level);
            if (node.left.prev != null) {
                node.left.prev.val += node.left.val;
                node.left.prev.next = node;
                node.prev = node.left.prev;
            }

            if (node.right.next != null) {
                node.right.next.val += node.right.val;
                node.right.next.prev = node;
                node.next = node.right.next;
            }

            node.leaf = true;
            node.left = null;
            node.right = null;
            return true;
        }

        if (tryExplode(node.left, level + 1)) return true;
        if (tryExplode(node.right, level + 1)) return true;
        return false;
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean trySplit(SnailfishNumber node, int level) {
        if (node.leaf) {
            if (node.val < splitFromValue) return false;
            if (debug) printer.println("splitted " + node.val + " on level " + level);

            node.left = new SnailfishNumber(node.val / 2);
            node.right = new SnailfishNumber((node.val + 1) / 2);
            node.left.next = node.right;
            node.right.prev = node.left;
            node.val = 0;
            node.leaf = false;
            if (node.prev != null) {
                node.prev.next = node.left;
                node.left.prev = node.prev;
            }

            if (node.next != null) {
                node.next.prev = node.right;
                node.right.next = node.next;
            }
            return true;
        }
        if (trySplit(node.left, level + 1)) return true;
        if (trySplit(node.right, level + 1)) return true;
        return false;
    }


    private static class SnailfishNumber {
        boolean leaf;

        //if leaf then val,prev,next
        //else a,b

        SnailfishNumber left, right, prev, next;
        int val;

        SnailfishNumber(int val) {
            this.leaf = true;
            this.val = val;
        }

        SnailfishNumber(SnailfishNumber left, SnailfishNumber right) {
            this.leaf = false;
            this.left = left;
            this.right = right;
        }

        public SnailfishNumber(boolean leaf, int val) {
            this.leaf = leaf;
            this.val = val;
        }


        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            dfsToString(sb);
            return sb.toString();
        }

        public String getNextLinks() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            SnailfishNumber tmp = this.next;
            while (tmp != null) {
                sb.append("->").append(tmp.val);
                tmp = tmp.next;
            }
            return sb.toString();
        }

        public String getPrevLinks() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.val);
            SnailfishNumber tmp = this.prev;
            while (tmp != null) {
                sb.append("<-").append(tmp.val);
                tmp = tmp.prev;
            }
            return sb.toString();
        }

        private void dfsToString(StringBuilder sb) {
            if (this.leaf) sb.append(this.val);
            else {
                sb.append('[');
                this.left.dfsToString(sb);
                sb.append(',');
                this.right.dfsToString(sb);
                sb.append(']');
            }
        }

        long score() {
            return leaf ? val : 3L * left.score() + 2L * right.score();
        }
    }

    private static class Parser {
        final String s;
        int currentPosition;

        public Parser(String s) {
            this.s = s;
        }

        ParserResult parse() {
            char c = s.charAt(currentPosition++);
            if (c >= '0' && c <= '9') {
                SnailfishNumber node = new SnailfishNumber(c - '0');
                return new ParserResult(node, node, node);
            } else {
                ParserResult a = parse();
                currentPosition++; // skip ','
                ParserResult b = parse();
                currentPosition++; // skip ']

                a.maxRight.next = b.maxLeft;
                b.maxLeft.prev = a.maxRight;

                SnailfishNumber node = new SnailfishNumber(a.node, b.node);
                return new ParserResult(node, a.maxLeft, b.maxRight);
            }
        }
    }

    private static class ParserResult {
        SnailfishNumber node;
        SnailfishNumber maxLeft;

        public ParserResult(SnailfishNumber node, SnailfishNumber maxLeft, SnailfishNumber maxRight) {
            this.node = node;
            this.maxLeft = maxLeft;
            this.maxRight = maxRight;
        }

        SnailfishNumber maxRight;
    }
}
