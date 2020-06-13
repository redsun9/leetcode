package leetcode.leetcode14xx.leetcode1476;

import java.util.LinkedList;

public class SubrectangleQueries {
    private final int[][] rectangle;
    private final LinkedList<Request> requests = new LinkedList<>();

    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        requests.addFirst(new Request(row1, col1, row2, col2, newValue));
    }

    public int getValue(int row, int col) {
        for (Request request : requests) {
            if (
                    request.i1 <= row && request.i2 >= row &&
                            request.j1 <= col && request.j2 >= col
            ) return request.val;
        }
        return rectangle[row][col];
    }

    private static class Request {
        private final int i1, j1, i2, j2, val;

        public Request(int i1, int j1, int i2, int j2, int val) {
            this.i1 = i1;
            this.j1 = j1;
            this.i2 = i2;
            this.j2 = j2;
            this.val = val;
        }
    }

}
