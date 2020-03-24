package basic;

import java.util.*;

public class ArrayTools {
    private static int sumWithLeastNumberOfElements(int[] a, int k) {
        int s = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++) {
            int cur = a[i];
            if (cur >= k) return 1;
            if (cur > 0) {
                while (!queue.isEmpty() && s > queue.peek() && s + cur - queue.peek() >= k) {
                    s -= queue.poll();
                }
                if (s < k) {
                    queue.offer(cur);
                    s += cur;
                }
            }
        }
        if (s < k) return -1;
        return queue.size();
    }

    /*
        Generate all permutations of nums
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] b;
        {
            LinkedList<int[]> borders = new LinkedList<>();
            int start = 0;
            for (int i = 1; i < n; i++) {
                if (nums[i] != nums[i - 1]) {
                    borders.add(new int[]{start, i});
                    start = i;
                }
            }
            borders.add(new int[]{start, n});
            b = borders.toArray(new int[borders.size()][]);
        }
        List<List<Integer>> res = new LinkedList<>();
        permuteUnique(nums, res, new boolean[n], b, 0, 0, n, new int[n]);
        return res;
    }

    private static void permuteUnique(
            int[] nums, List<List<Integer>> ans, boolean[] used,
            int[][] b, int groupIndex, int i, int n, int[] tmp
    ) {
        if (i == b[groupIndex][1]) groupIndex++;
        if (groupIndex == b.length) {
            Integer[] integers = new Integer[n];
            for (int j = 0; j < tmp.length; j++) {
                integers[tmp[j]] = nums[j];
            }
            ans.add(Arrays.asList(integers));
        } else {
            int j = b[groupIndex][0] == i ? 0 : tmp[i - 1] + 1;
            while (j < n) {
                if (!used[j]) {
                    used[j] = true;
                    tmp[i] = j;
                    permuteUnique(nums, ans, used, b, groupIndex, i + 1, n, tmp);
                    used[j] = false;
                }
                j++;
            }
        }
    }

    //usage kSum(nums, 0, k, target)
    private static List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 2) { //two pointers from left and right
            int left = start, right = len - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> path = new ArrayList<Integer>();
                    path.add(nums[left]);
                    path.add(nums[right]);
                    res.add(path);
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < target) { //move left
                    left++;
                } else { //move right
                    right--;
                }
            }
        } else {
            for (int i = start; i < len - (k - 1); i++) {
                if (i > start && nums[i] == nums[i - 1]) continue;
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
            }
        }
        return res;
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
