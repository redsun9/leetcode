package leetcode.leetcode20xx.leetcode2069;

public class Robot {
    private final int topBorder, rightBorder, part1, part2, part3, part4;
    private int position = 0;
    private boolean start = true;


    public Robot(int width, int height) {
        this.rightBorder = width - 1;
        this.topBorder = height - 1;
        this.part1 = width - 1;
        this.part2 = part1 + height - 1;
        this.part3 = part2 + width - 1;
        this.part4 = part3 + height - 1;
    }

    public void move(int num) {
        start = false;
        position += num;
        if (position >= part4) position %= part4;
    }

    public int[] getPos() {
        if (position <= part1) return new int[]{position, 0};
        else if (position <= part2) return new int[]{rightBorder, position - part1};
        else if (position <= part3) return new int[]{part3 - position, topBorder};
        else return new int[]{0, part4 - position};
    }

    public String getDir() {
        if (!start && (position == 0 || position > part3)) return "South";
        else if (position <= part1) return "East";
        else if (position <= part2) return "North";
        else return "West";
    }
}
