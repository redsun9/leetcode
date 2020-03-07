package codeforces.contest1320;

import java.util.*;

public class ProblemF {
    private final int n;
    private final int m;
    private final int k;

    private final int[][] bottom;
    private final int[][] bottomBorder;
    private final int[][] top;
    private final int[][] topBorder;
    private final int[][] left;
    private final int[][] leftBorder;
    private final int[][] right;
    private final int[][] rightBorder;
    private final int[][] front;
    private final int[][] frontBorder;
    private final int[][] back;
    private final int[][] backBorder;
    private final int[][][] field;

    public ProblemF(int n, int m, int k, int[][] bottom, int[][] top, int[][] left, int[][] right, int[][] front, int[][] back) {
        this.n = n;
        this.m = m;
        this.k = k;
        this.bottom = bottom;
        this.top = top;
        this.left = left;
        this.right = right;
        this.front = front;
        this.back = back;
        bottomBorder = new int[m][k];
        deepFill(bottomBorder, 0);
        topBorder = new int[m][k];
        deepFill(topBorder, n - 1);
        leftBorder = new int[n][k];
        deepFill(leftBorder, 0);
        rightBorder = new int[n][k];
        deepFill(rightBorder, m - 1);
        frontBorder = new int[n][m];
        deepFill(frontBorder, 0);
        backBorder = new int[n][m];
        deepFill(backBorder, k - 1);
        field = new int[n][m][k];
        deepFill(field, -1);

    }

    public int[][][] solve() {
        if (!processZerosForRightLeft() || !processZerosForFrontBack() || !processZerosForBottomAndTop()) {
            return null;
        }
        if (!shiftBorders()) {
            return null;
        }

        LinkedList<Triple> coords = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (front[i][j] == 0) continue;
                for (int l = 0; l < k; l++) {
                    if (bottom[j][l] == 0 || left[i][l] == 0) continue;
                    coords.add(new Triple(i, j, l));
                }
            }
        }
        coords.sort(Comparator.comparingInt(triple ->
                Math.min(triple.i, n - 1 - triple.i) + Math.min(triple.j, m - 1 - triple.j) + Math.min(triple.l, k - 1 - triple.l)
        ));

        int deletedLastIter = 1;
        while (deletedLastIter != 0) {
            deletedLastIter = 0;
            ListIterator<Triple> listIterator = coords.listIterator();
            while (listIterator.hasNext()) {
                Triple triple = listIterator.next();
                int code = process(triple.i, triple.j, triple.l);
                if (code == 1) {
                    listIterator.remove();
                    deletedLastIter++;
                }
                if (code == 2) {
                    return null;
                }
            }
        }
        prepareToOutput();
        return field;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[][] bottom = new int[m][k];
        int[][] top = new int[m][k];
        int[][] left = new int[n][k];
        int[][] right = new int[n][k];
        int[][] front = new int[n][m];
        int[][] back = new int[n][m];

        read2dArray(scanner, bottom, m, k);
        read2dArray(scanner, top, m, k);
        read2dArray(scanner, left, n, k);
        read2dArray(scanner, right, n, k);
        read2dArray(scanner, front, n, m);
        read2dArray(scanner, back, n, m);

        ProblemF problemF = new ProblemF(n, m, k, bottom, top, left, right, front, back);
        int[][][] result = problemF.solve();
        if (result != null) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int l = 0; l < k; l++) {
                        System.out.print(result[i][j][l] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
            }
        } else {
            System.out.println(-1);
        }
    }

    private void prepareToOutput() {
        deepFill(field, 0);
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                field[bottomBorder[j][l]][j][l] = bottom[j][l];
                field[topBorder[j][l]][j][l] = top[j][l];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                field[i][leftBorder[i][l]][l] = left[i][l];
                field[i][rightBorder[i][l]][l] = right[i][l];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                field[i][j][frontBorder[i][j]] = front[i][j];
                field[i][j][backBorder[i][j]] = back[i][j];
            }
        }
    }

    //0-nothing, 1 - deleted, 2 - conflict
    private int process(int i, int j, int l) {
        if (field[i][j][l] == -1) {
            //проверка видимости
            int prevColour = -1;
            boolean conflict = false;
            if (bottomBorder[j][l] == i) {
                prevColour = bottom[j][l];
            }
            if (topBorder[j][l] == i) {
                if (prevColour == -1 || prevColour == top[j][l]) {
                    prevColour = top[j][l];
                } else {
                    conflict = true;
                }
            }
            if (leftBorder[i][l] == j) {
                if (prevColour == -1 || prevColour == left[i][l]) {
                    prevColour = left[i][l];
                } else {
                    conflict = true;
                }
            }
            if (rightBorder[i][l] == j) {
                if (prevColour == -1 || prevColour == right[i][l]) {
                    prevColour = right[i][l];
                } else {
                    conflict = true;
                }
            }
            if (frontBorder[i][j] == l) {
                if (prevColour == -1 || prevColour == front[i][j]) {
                    prevColour = front[i][j];
                } else {
                    conflict = true;
                }
            }
            if (backBorder[i][j] == l) {
                if (prevColour != -1 && prevColour != back[i][j]) {
                    conflict = true;
                }
            }
            if (conflict) {
                field[i][j][l] = 0;
                if (bottomBorder[j][l] == i) {
                    if (!shiftBottom(j, l)) {
                        return 2;
                    }
                }
                if (top[j][l] == i) {
                    if (!shiftTop(j, l)) {
                        return 2;
                    }
                }
                if (leftBorder[i][l] == j) {
                    if (!shiftLeft(i, l)) {
                        return 2;
                    }
                }
                if (rightBorder[i][l] == j) {
                    if (!shiftRight(i, l)) {
                        return 2;
                    }
                }
                if (frontBorder[i][j] == l) {
                    if (!shiftFront(i, j)) {
                        return 2;
                    }
                }
                if (backBorder[i][j] == l) {
                    if (!shiftBack(i, j)) {
                        return 2;
                    }
                }
                return 1;
            }
            return 0;
        } else {
            return 1;
        }
    }

    private boolean processZerosForBottomAndTop() {
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                if (bottom[j][l] == 0 || top[j][l] == 0) {
                    if (bottom[j][l] == 0 && top[j][l] == 0) {
                        for (int i = 0; i < n; i++) {
                            field[i][j][l] = 0;
                        }
                    } else return false;
                }
            }
        }
        return true;
    }

    private boolean processZerosForRightLeft() {
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                if (left[i][l] == 0 || right[i][l] == 0) {
                    if (left[i][l] == 0 && right[i][l] == 0) {
                        for (int j = 0; j < m; j++) {
                            field[i][j][l] = 0;
                        }
                    } else return false;
                }
            }
        }
        return true;
    }

    private boolean processZerosForFrontBack() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (front[i][j] == 0 || back[i][j] == 0) {
                    if (front[i][j] == 0 && back[i][j] == 0) {
                        for (int l = 0; l < k; l++) {
                            field[i][j][l] = 0;
                        }
                    } else return false;
                }
            }
        }
        return true;
    }

    private boolean shiftBottom(int j, int l) {
        if (bottom[j][l] == 0) return true;
        while (field[bottomBorder[j][l]][j][l] != -1) {
            bottomBorder[j][l]++;
            if (bottomBorder[j][l] >= n) {
                return false;
            }
        }
        return true;
    }

    private boolean shiftTop(int j, int l) {
        if (top[j][l] == 0) return true;
        while (field[topBorder[j][l]][j][l] != -1) {
            topBorder[j][l]--;
            if (topBorder[j][l] < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shiftLeft(int i, int l) {
        if (left[i][l] == 0) return true;
        while (field[i][leftBorder[i][l]][l] != -1) {
            leftBorder[i][l]++;
            if (leftBorder[i][l] >= m) {
                return false;
            }
        }
        return true;
    }

    private boolean shiftRight(int i, int l) {
        if (right[i][l] == 0) return true;
        while (field[i][rightBorder[i][l]][l] != -1) {
            rightBorder[i][l]--;
            if (rightBorder[i][l] < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shiftFront(int i, int j) {
        if (front[i][j] == 0) return true;
        while (field[i][j][frontBorder[i][j]] != -1) {
            frontBorder[i][j]++;
            if (frontBorder[i][j] >= k) {
                return false;
            }
        }
        return true;
    }

    private boolean shiftBack(int i, int j) {
        if (back[i][j] == 0) return true;
        while (field[i][j][backBorder[i][j]] != -1) {
            backBorder[i][j]--;
            if (backBorder[i][j] < 0) {
                return false;
            }
        }
        return true;
    }

    private boolean shiftTop() {
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                if (!shiftTop(j, l)) return false;
            }
        }
        return true;
    }

    private boolean shiftBottom() {
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                if (!shiftBottom(j, l)) return false;
            }
        }
        return true;
    }

    private boolean shiftLeft() {
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                if (!shiftLeft(i, l)) return false;
            }
        }
        return true;
    }

    private boolean shiftRight() {
        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                if (!shiftRight(i, l)) return false;
            }
        }
        return true;
    }

    private boolean shiftFront() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!shiftFront(i, j)) return false;
            }
        }
        return true;
    }

    private boolean shiftBack() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!shiftBack(i, j)) return false;
            }
        }
        return true;
    }

    private boolean shiftBorders() {
        return shiftBottom() && shiftBack() && shiftFront() && shiftLeft() && shiftRight() && shiftTop();
    }

    private static void read1dArray(Scanner scanner, int[] a, int n) {
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
    }

    private static void read2dArray(Scanner scanner, int[][] a, int n1, int n2) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                a[i][j] = scanner.nextInt();
            }
        }
    }

    public static void deepFill(Object[] arr, Object val) {
        if (isArray(arr[0])) {
            if (arr[0] instanceof boolean[]) {
                boolean boolVal = (boolean) val;
                boolean[][] boolArr = (boolean[][]) arr;
                for (boolean[] o : boolArr) {
                    Arrays.fill(o, boolVal);
                }
            } else if (arr[0] instanceof byte[]) {
                byte byteVal = (byte) val;
                byte[][] byteArr = (byte[][]) arr;
                for (byte[] o : byteArr) {
                    Arrays.fill(o, byteVal);
                }
            } else if (arr[0] instanceof short[]) {
                short shortVal = (short) val;
                short[][] shortVar = (short[][]) arr;
                for (short[] o : shortVar) {
                    Arrays.fill(o, shortVal);
                }
            } else if (arr[0] instanceof char[]) {
                char charVal = (char) val;
                char[][] charArr = (char[][]) arr;
                for (char[] o : charArr) {
                    Arrays.fill(o, charVal);
                }
            } else if (arr[0] instanceof int[]) {
                int intVal = (int) val;
                int[][] intArr = (int[][]) arr;
                for (int[] o : intArr) {
                    Arrays.fill(o, intVal);
                }
            } else if (arr[0] instanceof long[]) {
                long longVal = (long) val;
                long[][] longArr = (long[][]) arr;
                for (long[] o : longArr) {
                    Arrays.fill(o, longVal);
                }
            } else if (arr[0] instanceof float[]) {
                float floatVal = (float) val;
                float[][] floatArr = (float[][]) arr;
                for (float[] o : floatArr) {
                    Arrays.fill(o, floatVal);
                }
            } else if (arr[0] instanceof double[]) {
                double doubleVal = (double) val;
                double[][] doubleArr = (double[][]) arr;
                for (double[] o : doubleArr) {
                    Arrays.fill(o, doubleVal);
                }
            } else if (arr[0] instanceof Object[]) {
                for (Object o : arr) {
                    deepFill((Object[]) o, val);
                }
            } else {
                throw new RuntimeException("WTF?");
            }
        } else {
            Arrays.fill(arr, val);
        }
    }

    public static boolean isArray(final Object obj) {
        return obj instanceof Object[] || obj instanceof boolean[] ||
                obj instanceof byte[] || obj instanceof short[] ||
                obj instanceof char[] || obj instanceof int[] ||
                obj instanceof long[] || obj instanceof float[] ||
                obj instanceof double[];
    }

    private static class Triple {
        public int i;
        public int j;
        public int l;

        public Triple(int i, int j, int l) {
            this.i = i;
            this.j = j;
            this.l = l;
        }
    }
}