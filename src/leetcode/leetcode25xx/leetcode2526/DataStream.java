package leetcode.leetcode25xx.leetcode2526;

public class DataStream {
    private final int value, k;
    private int curr = 0;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }

    //add num to stream, return true if last k values in a stream equals to value
    public boolean consec(int num) {
        if (num == value) curr++;
        else curr = 0;
        return curr >= k;
    }
}
