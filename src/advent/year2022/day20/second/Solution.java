package advent.year2022.day20.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final long DECRYPTION_KEY = 811589153L;
    private static final int TIMES = 10;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day20/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day20/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            Node head = new Node(0), tmp = head;
            int n = 0;
            while (scanner.hasNextLine()) {
                int num = Integer.parseInt(scanner.nextLine().trim());
                Node node = new Node(num * DECRYPTION_KEY);
                tmp.next = node;
                tmp.right = node;
                node.left = tmp;
                tmp = tmp.next;
                n++;
            }
            head.right.left = tmp;
            tmp.right = head.right;

            for (int i = 0; i < TIMES; i++) process(head, n);

            while (tmp.next != null) {
                tmp = tmp.next;
                int shiftRight = (int) (tmp.val % (n - 1));
                if (shiftRight < 0) shiftRight += (n - 1);
                int shiftLeft = (n - 1) - shiftRight;

                if (shiftRight < shiftLeft) tmp.shiftRight(shiftRight);
                else tmp.shiftLeft(shiftLeft);
            }

            while (tmp.val != 0) tmp = tmp.right;
            long ans = 0;
            for (int i = 1; i <= 3; i++) {
                int shiftRight = i * 1000 % n;
                int shiftLeft = n - shiftRight;
                if (shiftRight < shiftLeft) ans += tmp.getFromRightSkipping(shiftRight).val;
                else ans += tmp.getFromLeftSkipping(shiftLeft).val;
            }
            printer.println(ans);
        }
    }

    private static void process(Node head, int n) {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            int shiftRight = (int) (tmp.val % (n - 1));
            if (shiftRight < 0) shiftRight += (n - 1);
            int shiftLeft = (n - 1) - shiftRight;

            if (shiftRight < shiftLeft) tmp.shiftRight(shiftRight);
            else tmp.shiftLeft(shiftLeft);
        }
    }

    private static class Node {
        final long val;
        Node next, left, right;

        private Node(long val) {
            this.val = val;
        }

        void shiftRight(int steps) {
            Node nodeRight = this.right;
            this.left.right = this.right;
            this.right.left = this.left;
            while (steps-- != 0) nodeRight = nodeRight.right;
            this.right = nodeRight;
            this.left = nodeRight.left;
            nodeRight.left.right = this;
            nodeRight.left = this;
        }

        void shiftLeft(int steps) {
            Node nodeLeft = this.left;
            this.left.right = this.right;
            this.right.left = this.left;
            while (steps-- != 0) nodeLeft = nodeLeft.left;
            this.left = nodeLeft;
            this.right = nodeLeft.right;
            nodeLeft.right.left = this;
            nodeLeft.right = this;
        }

        Node getFromLeftSkipping(int toSkip) {
            Node ans = this;
            while (toSkip-- != 0) ans = ans.left;
            return ans;
        }

        Node getFromRightSkipping(int toSkip) {
            Node ans = this;
            while (toSkip-- != 0) ans = ans.right;
            return ans;
        }

        @Override
        public String toString() {
            Node tmp = this;
            while (tmp != null && tmp.val != 0) tmp = tmp.right;
            if (tmp == null) return "null";
            StringBuilder sb = new StringBuilder();
            sb.append(0);
            while (tmp.right != null && tmp.right.val != 0) {
                tmp = tmp.right;
                sb.append(',').append(tmp.val);
            }
            return sb.toString();
        }
    }
}
