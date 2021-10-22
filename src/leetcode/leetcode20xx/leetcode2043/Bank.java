package leetcode.leetcode20xx.leetcode2043;

public class Bank {
    private final long[] balance;
    private final int n;

    public Bank(long[] balance) {
        this.balance = balance;
        this.n = balance.length;
    }

    public boolean transfer(int from, int to, long money) {
        if (from < 1 || from > n || to < 1 || to > n || money < 0 || balance[from - 1] < money) return false;
        balance[from - 1] -= money;
        balance[to - 1] += money;
        return true;
    }

    public boolean deposit(int to, long money) {
        if (to < 1 || to > n || money < 0) return false;
        balance[to - 1] += money;
        return true;
    }

    public boolean withdraw(int from, long money) {
        if (from < 1 || from > n || money < 0 || balance[from - 1] < money) return false;
        balance[from - 1] -= money;
        return true;
    }
}
