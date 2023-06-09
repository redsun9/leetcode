package help_requests.favorite_number;


/*
    There is N without zeros. Find probability that after K swaps of digits,
    number will be divisible by 5,6 or 10.
 */
public class Solution {
    public static double happyProbability(long n, int k) {
        boolean divisibleByThree = n % 3 == 0;
        int a = 0, b = 0, m = 0;
        double p = n % 6 == 0 || n % 5 == 0 ? 1.0 : 0.0;

        while (n != 0) {
            int digit = (int) (n % 10);
            if (digit == 5 || divisibleByThree && digit % 2 == 0) a++;
            else b++;
            m++;
            n /= 10;
        }

        double c1 = 1.0 - b * 2.0 / m / (m - 1);
        double c2 = a * 2.0 / m / (m - 1);

        for (int i = 0; i < k; i++) p = p * c1 + (1.0 - p) * c2;
        return p;
    }

    public static void main(String[] args) {
        System.out.println(happyProbability(1165111155512162L, 100));
    }
}


