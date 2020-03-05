package codeforces.contest1320;

import java.util.*;

public class ProblemF {
    private static int n;
    private static int m;
    private static int k;

    private static int[][] bottom;
    private static int[][] bottomBorder;
    private static int[][] top;
    private static int[][] topBorder;
    private static int[][] left;
    private static int[][] leftBorder;
    private static int[][] right;
    private static int[][] rightBorder;
    private static int[][] front;
    private static int[][] frontBorder;
    private static int[][] back;
    private static int[][] backBorder;
    private static int[][][] field;

    private static void input() {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();

        bottom = new int[m][k];
        top = new int[m][k];
        left = new int[n][k];
        right = new int[n][k];
        front = new int[n][m];
        back = new int[n][m];

        read2dArray(scanner, bottom, m, k);
        read2dArray(scanner, top, m, k);
        read2dArray(scanner, left, n, k);
        read2dArray(scanner, right, n, k);
        read2dArray(scanner, front, n, m);
        read2dArray(scanner, back, n, m);
    }

    private static void output() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
                    System.out.print(field[i][j][l] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.println();
        }
    }

    private static void prepareArrays() {
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

    public static void main(String[] args) {
        input();
        prepareArrays();

        if (!processZerosForRightLeft() || !processZerosForFrontBack() || !processZerosForBottomAndTop()) {
            System.out.println(-1);
            return;
        }
        if (!shiftBorders()) {
            System.out.println(-1);
            return;
        }

        LinkedList<Triple> coords = new LinkedList<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int l = 0; l < k; l++) {
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
                    System.out.println(-1);
                    return;
                }
            }
        }

        prepareToOutput();
        output();
    }

    private static void prepareToOutput() {
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
    private static int process(int i, int j, int l) {
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
                    int t = bottomBorder[j][l] + 1;
                    while (t < n) {
                        if (field[t][j][l] == -1) break;
                        t++;
                    }
                    if (t < n) {
                        bottomBorder[j][l] = t;
                    } else {
                        return 2;
                    }
                }
                if (top[j][l] == i) {
                    int t = top[j][l] - 1;
                    while (t > 0) {
                        if (field[t][j][l] == -1) break;
                        t--;
                    }
                    if (t >= 0) {
                        bottomBorder[j][l] = t;
                    } else {
                        return 2;
                    }
                }
                if (leftBorder[i][l] == j) {
                    int t = leftBorder[i][l] + 1;
                    while (t < n) {
                        if (field[i][t][l] == -1) break;
                        t++;
                    }
                    if (t < m) {
                        leftBorder[i][l] = t;
                    } else {
                        return 2;
                    }
                }
                if (rightBorder[i][l] == j) {
                    int t = rightBorder[i][l] - 1;
                    while (t >= 0) {
                        if (field[i][t][l] == -1) break;
                        t--;
                    }
                    if (t >= 0) {
                        rightBorder[i][l] = t;
                    } else {
                        return 2;
                    }
                }
                if (frontBorder[i][j] == l) {
                    int t = frontBorder[i][j] + 1;
                    while (t < k) {
                        if (field[i][j][t] == -1) break;
                        t++;
                    }
                    if (t < k) {
                        frontBorder[i][j] = t;
                    } else {
                        return 2;
                    }
                }
                if (backBorder[i][j] == l) {
                    int t = backBorder[i][j] - 1;
                    while (t >= 0) {
                        if (field[i][j][t] == -1) break;
                        t--;
                    }
                    if (t >= 0) {
                        backBorder[i][j] = t;
                    } else {
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

    private static boolean processZerosForBottomAndTop() {
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

    private static boolean processZerosForRightLeft() {
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

    private static boolean processZerosForFrontBack() {
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

    private static boolean shiftBorders() {
        for (int j = 0; j < m; j++) {
            for (int l = 0; l < k; l++) {
                if (field[0][j][l] == 0 && bottom[j][l] != 0) {
                    int t = bottomBorder[j][l] + 1;
                    while (t < n) {
                        if (field[t][j][l] == -1) break;
                        t++;
                    }
                    if (t < n) {
                        bottomBorder[j][l] = t;
                    } else {
                        return false;
                    }
                }
                if (field[n - 1][j][l] == 0 && top[j][l] != 0) {
                    int t = topBorder[j][l] - 1;
                    while (t > 0) {
                        if (field[t][j][l] == -1) break;
                        t--;
                    }
                    if (t >= 0) {
                        topBorder[j][l] = t;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int l = 0; l < k; l++) {
                if (field[i][0][l] == 0 && left[i][l] != 0) {
                    int t = leftBorder[i][l] + 1;
                    while (t < n) {
                        if (field[i][t][l] == -1) break;
                        t++;
                    }
                    if (t < m) {
                        leftBorder[i][l] = t;
                    } else {
                        return false;
                    }
                }
                if (field[i][m - 1][l] == 0 && right[i][l] != 0) {
                    int t = rightBorder[i][l] - 1;
                    while (t >= 0) {
                        if (field[i][t][l] == -1) break;
                        t--;
                    }
                    if (t >= 0) {
                        rightBorder[i][l] = t;
                    } else {
                        return false;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (field[i][j][0] == 0 && front[i][j] != 0) {
                    int t = frontBorder[i][j] + 1;
                    while (t < k) {
                        if (field[i][j][t] == -1) break;
                        t++;
                    }
                    if (t < k) {
                        frontBorder[i][j] = t;
                    } else {
                        return false;
                    }
                }
                if (field[i][j][k - 1] == 0 && back[i][j] != 0) {
                    int t = backBorder[i][j] - 1;
                    while (t >= 0) {
                        if (field[i][j][t] == -1) break;
                        t--;
                    }
                    if (t >= 0) {
                        backBorder[i][j] = t;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
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