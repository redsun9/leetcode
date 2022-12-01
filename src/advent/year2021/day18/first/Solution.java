package advent.year2021.day18.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode", "SuspiciousNameCombination"})
public class Solution {
    private static final int reduceFromLevel = 4;
    private static final int splitFromValue = 10;

    private static PrintStream printer;
    private static final boolean debug = false;


    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day18/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day18/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Solution.printer = printer;
            ParserResult x = new Parser(scanner.nextLine()).parse();
            if (debug) {
                printer.println("current x");
                printDebug(x);
            }

            while (scanner.hasNextLine()) {
                ParserResult y = new Parser(scanner.nextLine()).parse();
                if (debug) {
                    printer.println("current y");
                    printDebug(y);
                }

                x.maxRight.next = y.maxLeft;
                y.maxLeft.prev = x.maxRight;

                x = new ParserResult(new SnailfishNumber(x.node, y.node), x.maxLeft, y.maxRight);

                reduce(x);
                if (debug) printer.println("score = " + x.node.score());
            }
            printer.println(x.node.score());
        }
    }

    private static void printDebug(ParserResult x) {
        printer.println("x = " + x.node);
        printer.println(x.maxLeft.getNextLinks());
        printer.println(x.maxRight.getPrevLinks());
        printer.println();
    }

    private static void reduce(ParserResult x) {
        while (true) {
            if (debug) {
                printer.println("before reduce");
                printDebug(x);
            }
            if (tryExplode(x, x.node, 0)) continue;
            if (trySplit(x, x.node, 0)) continue;
            break;
        }
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean tryExplode(ParserResult x, SnailfishNumber node, int level) {
        if (node.leaf) return false;
        if (level >= reduceFromLevel && node.a.leaf && node.b.leaf) {
            if (debug) printer.println("reduced " + node.a.val + " " + node.b.val + " on level " + level);
            if (node.a.prev != null) {
                node.a.prev.val += node.a.val;
                node.a.prev.next = node;
                node.prev = node.a.prev;
            } else x.maxLeft = node;

            if (node.b.next != null) {
                node.b.next.val += node.b.val;
                node.b.next.prev = node;
                node.next = node.b.next;
            } else x.maxRight = node;

            node.leaf = true;
            node.a = null;
            node.b = null;
            return true;
        }

        if (tryExplode(x, node.a, level + 1)) return true;
        if (tryExplode(x, node.b, level + 1)) return true;
        return false;
    }

    @SuppressWarnings("RedundantIfStatement")
    private static boolean trySplit(ParserResult x, SnailfishNumber node, int level) {
        if (node.leaf) {
            if (node.val < splitFromValue) return false;
            if (debug) printer.println("splitted " + node.val + " on level " + level);

            node.a = new SnailfishNumber(node.val / 2);
            node.b = new SnailfishNumber((node.val + 1) / 2);
            node.a.next = node.b;
            node.b.prev = node.a;
            node.val = 0;
            node.leaf = false;
            if (node.prev != null) {
                node.prev.next = node.a;
                node.a.prev = node.prev;
            } else x.maxLeft = node.a;

            if (node.next != null) {
                node.next.prev = node.b;
                node.b.next = node.next;
            } else x.maxRight = node.b;
            return true;
        }
        if (trySplit(x, node.a, level + 1)) return true;
        if (trySplit(x, node.b, level + 1)) return true;
        return false;
    }


    private static class SnailfishNumber {
        boolean leaf;

        //if leaf then val,prev,next
        //else a,b

        SnailfishNumber a, b, prev, next;
        int val;

        SnailfishNumber(int val) {
            this.leaf = true;
            this.val = val;
        }

        SnailfishNumber(SnailfishNumber a, SnailfishNumber b) {
            this.leaf = false;
            this.a = a;
            this.b = b;
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
                this.a.dfsToString(sb);
                sb.append(',');
                this.b.dfsToString(sb);
                sb.append(']');
            }
        }

        long score() {
            return leaf ? val : 3L * a.score() + 2L * b.score();
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
