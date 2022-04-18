package leetcode.leetcode22xx.leetcode2241;

public class ATM {
    private static final int TOTAL_BANKNOTES = 5;
    private final long[] banknotesCount = new long[TOTAL_BANKNOTES];
    private final int[] banknotes = {20, 50, 100, 200, 500};
    private static final int[] errorResponse = {-1};

    public void deposit(int[] banknotesCount) {
        for (int i = 0; i < TOTAL_BANKNOTES; i++) {
            this.banknotesCount[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] ans = new int[TOTAL_BANKNOTES];
        for (int i = TOTAL_BANKNOTES - 1; i >= 0; i--) {
            int count = (int) Math.min(amount / banknotes[i], banknotesCount[i]);
            ans[i] = count;
            amount -= count * banknotes[i];
        }
        if (amount != 0) return errorResponse;
        else {
            for (int i = 0; i < TOTAL_BANKNOTES; i++) banknotesCount[i] -= ans[i];
            return ans;
        }
    }
}
