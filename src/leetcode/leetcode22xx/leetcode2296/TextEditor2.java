package leetcode.leetcode22xx.leetcode2296;

public class TextEditor2 {
    private char[] left, right;
    private int leftSize, rightSize, leftCapacity, rightCapacity;

    public TextEditor2() {
        left = new char[1024];
        right = new char[1024];
        leftSize = rightSize = 0;
        leftCapacity = rightCapacity = 1024;
    }

    public void addText(String text) {
        int n = text.length();
        if (leftSize + n > leftCapacity) {
            int newCapacity = Math.max(leftCapacity * 2, leftSize + n);
            char[] newLeft = new char[newCapacity];
            System.arraycopy(left, 0, newLeft, 0, leftSize);
            left = newLeft;
            leftCapacity = newCapacity;
        }
        char[] chars = text.toCharArray();
        System.arraycopy(chars, 0, left, leftSize, n);
        leftSize += n;
    }

    public int deleteText(int k) {
        int ans = Math.min(k, leftSize);
        leftSize -= ans;
        return ans;
    }

    public String cursorLeft(int k) {
        int shift = Math.min(k, leftSize);
        if (rightSize + shift > rightCapacity) {
            int newCapacity = Math.max(rightCapacity * 2, rightSize + shift);
            char[] newRight = new char[newCapacity];
            System.arraycopy(right, rightCapacity - rightSize, newRight, newCapacity - rightSize, rightSize);
            right = newRight;
            rightCapacity = newCapacity;
        }
        System.arraycopy(left, leftSize - shift, right, rightCapacity - rightSize - shift, shift);
        rightSize += shift;
        leftSize -= shift;
        return getString();
    }

    public String cursorRight(int k) {
        int shift = Math.min(k, rightSize);
        if (leftSize + shift > leftCapacity) {
            int newCapacity = Math.max(leftCapacity * 2, leftSize + shift);
            char[] newLeft = new char[newCapacity];
            System.arraycopy(left, 0, newLeft, 0, leftSize);
            left = newLeft;
            leftCapacity = newCapacity;
        }
        System.arraycopy(right, rightCapacity - rightSize, left, leftSize, shift);
        leftSize += shift;
        rightSize -= shift;
        return getString();
    }

    private String getString() {
        return new String(left, leftSize - Math.min(leftSize, 10), Math.min(leftSize, 10));
    }
}
