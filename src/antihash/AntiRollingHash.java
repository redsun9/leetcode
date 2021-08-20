package antihash;

public class AntiRollingHash {
    private static final int Q1 = 10, Q2 = 20;
    private static final int N1 = 1 << Q1, N2 = 1 << Q2;
    public static final String str11, str12, str21, str22;

    static {
        char[] a = new char[N1], b = new char[N1];
        for (int i = 0; i < N1; i++) {
            a[i] = (char) ('a' + Integer.bitCount(i) % 2);
            b[i] = (char) ('b' - Integer.bitCount(i) % 2);
        }
        str11 = new String(a);
        str12 = new String(b);

        a = new char[N2];
        b = new char[N2];
        for (int i = 0; i < N2; i++) {
            a[i] = (char) ('a' + Integer.bitCount(i) % 2);
            b[i] = (char) ('b' - Integer.bitCount(i) % 2);
        }
        str21 = new String(a);
        str22 = new String(b);
    }
}
