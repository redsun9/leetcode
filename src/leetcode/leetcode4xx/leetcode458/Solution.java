package leetcode.leetcode4xx.leetcode458;

public class Solution {
    /*
        let's assume f(m,k) - maximum number of buckets which can be tested in m rounds by k pigs/
        f(0,k)=1
        f(m,0)=1
        f(m,k)=sum_{i=0}^(k} C^i_k * f(m-1,i)

        f(1,k) = 2^k
        By induction we prove that f(m,k)=(m+1)^k
        sum_{i=0}^(k} C^i_k * f(m-1,i) = sum_{i=0}^(k} С^i_k * m^i = (m+1)^k

     */


    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int m = minutesToTest / minutesToDie;
        int k = (int) (Math.log(buckets) / Math.log(m + 1));
        if (binPow(m + 1, k) < buckets) k++;
        return k;
    }

    private static long binPow(int a, int n) {
        long res = 1;
        long tmp = a;
        while (n != 0) {
            if ((n & 1) != 0)
                res *= tmp;
            tmp *= tmp;
            n >>= 1;
        }
        return res;
    }
}
