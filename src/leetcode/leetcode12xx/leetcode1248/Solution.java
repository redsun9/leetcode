package leetcode.leetcode12xx.leetcode1248;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int n = nums.length;
        int l = 0, r = 0, d = 0;
        while (r<n){
            if((nums[r++]&1)==0){
                if(k<=0) ans+=d;
            }else{
                if(--k<=0){
                    d = 1;
                    while ((nums[l++]&1)==0) d++;
                    ans+=d;
                }
            }
        }
        return ans;
    }
}
