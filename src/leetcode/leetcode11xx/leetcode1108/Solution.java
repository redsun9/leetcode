package leetcode.leetcode11xx.leetcode1108;

public class Solution {
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[.]");
    }
}
