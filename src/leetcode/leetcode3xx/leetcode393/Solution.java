package leetcode.leetcode3xx.leetcode393;

public class Solution {
    private static final int oneByteMsk = 0b1000_0000;
    private static final int oneByteVal = 0b0000_0000;
    private static final int twoByteMsk = 0b1110_0000;
    private static final int twoByteVal = 0b1100_0000;
    private static final int threeByteMsk = 0b1111_0000;
    private static final int threeByteVal = 0b1110_0000;
    private static final int fourByteMsk = 0b1111_1000;
    private static final int fourByteVal = 0b1111_0000;
    private static final int nonMainOctetMsk = 0b1100_0000;
    private static final int nonMainOctetVal = 0b1000_0000;


    public boolean validUtf8(int[] data) {
        int n = data.length;
        int i = 0;
        while (i < n) {
            int nonMainOctet;
            if ((data[i] & oneByteMsk) == oneByteVal) nonMainOctet = 0;
            else if ((data[i] & twoByteMsk) == twoByteVal) nonMainOctet = 1;
            else if ((data[i] & threeByteMsk) == threeByteVal) nonMainOctet = 2;
            else if ((data[i] & fourByteMsk) == fourByteVal) nonMainOctet = 3;
            else return false;
            if (i + nonMainOctet >= n) return false;
            i++;
            for (int j = 0; j < nonMainOctet; j++, i++) {
                if ((data[i] & nonMainOctetMsk) != nonMainOctetVal) return false;
            }
        }
        return true;
    }
}
