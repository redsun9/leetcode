package basic;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTools {
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

    private static void read3dArray(Scanner scanner, int[][][] a, int n1, int n2, int n3) {
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n3; k++) {
                    a[i][j][k] = scanner.nextInt();
                }
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
}
