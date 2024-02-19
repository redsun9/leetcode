package help_requests.iluha_equation;

// d = 997*b*c / (1000*a + 997*c)
public class Solution {
    public static int[] solveForB(int a, int c, int d) {
        int loB = ceilDiv(d * (1000 * a + 997 * c), 997 * c);
        int hiB = ((d + 1) * (1000 * a + 997 * c) - 1) / (997 * c);
        if (loB <= hiB) return new int[]{loB, hiB};
        else return null;
    }

    public static int[] solveForA(int b, int c, int d) {
        int loA = ceilDiv(997 * c * (b - (d + 1)) + 1, 1000 * (d + 1));
        int hiA = 997 * c * (b - d) / (1000 * d);
        if (loA <= hiA) return new int[]{loA, hiA};
        else return null;
    }


    private static int ceilDiv(int x, int y) {
        return (x + y - 1) / y;
    }
}
