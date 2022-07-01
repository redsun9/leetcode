package google.foobar.level3.find_the_access_codes;


//Benchmark             Mode  Cnt    Score   Error  Units
//PerfTestExample.sol1  avgt   10  272.827 ± 1.522  ms/op
//PerfTestExample.sol2  avgt   10  543.831 ± 2.596  ms/op

public class Answer {
    public static int answer(int[] nums) {
        int ans = 0, n = nums.length;
        int[] l = new int[n], r = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] % nums[i] == 0) {
                    l[j]++;
                    r[i]++;
                }
            }
        }
        for (int i = 1; i < n; i++) ans += l[i] * r[i];
        return ans;
    }

    public static int answer2(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 1; i < n - 1; i++) {
            int l = 0, r = 0, num = nums[i];
            for (int j = 0; j < i; j++) if (num % nums[j] == 0) l++;
            for (int j = i + 1; j < n; j++) if (nums[j] % num == 0) r++;
            ans += l * r;
        }
        return ans;
    }
}
