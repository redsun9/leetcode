package leetcode.leetcode1363;

class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int length = digits.length;
        if (length == 0) return "";
        if (length == 1) {
            if (digits[0] % 3 == 0) {
                return "" + digits[0];
            } else return "";
        }
        int[] counted = new int[10];
        int sum12 = 0;
        int sum3 = 0;
        int mod1 = 0;
        int mod2 = 0;
        int mod3 = 0;
        for (int i : digits) {
            switch (i % 3) {
                case 0:
                    mod3++;
                    sum3 += i;
                    break;
                case 1:
                    mod1++;
                    sum12 += i;
                    break;
                case 2:
                    mod2++;
                    sum12 += i;
                    break;
            }
            counted[i]++;
        }
        if (sum12 % 3 != 0) {
            if (sum12 % 3 == 1) {
                if (mod1 != 0) {
                    for (int i = 1; i <= 7; i += 3) {
                        if (counted[i] != 0) {
                            sum12 -= i;
                            counted[i]--;
                            length--;
                            break;
                        }
                    }
                } else if (mod2 >= 2) {
                    int required = 2;
                    for (int i = 2; i <= 8; i += 3) {
                        if (counted[i] != 0) {
                            int founded = Math.min(required, counted[i]);
                            sum12 -= i * founded;
                            counted[i] -= founded;
                            length -= founded;
                            mod2 -= founded;
                            required -= founded;
                            if (required == 0) break;
                        }
                    }
                }
            } else if (sum12 % 3 == 2) {
                if (mod2 != 0) {
                    for (int i = 2; i <= 8; i += 3) {
                        if (counted[i] != 0) {
                            sum12 -= i;
                            counted[i]--;
                            length--;
                            break;
                        }
                    }
                } else if (mod1 >= 2) {
                    int required = 2;
                    for (int i = 1; i <= 7; i += 3) {
                        if (counted[i] != 0) {
                            int founded = Math.min(required, counted[i]);
                            sum12 -= i * founded;
                            counted[i] -= founded;
                            length -= founded;
                            mod1 -= founded;
                            required -= founded;
                            if (required == 0) break;
                        }
                    }
                }
            }
        }
        if (sum12 != 0 && sum12 % 3 == 0) {
            // вывести все
            StringBuilder sb = new StringBuilder(length);
            for (int i = 9; i >= 0; i--) {
                for (int j = 0; j < counted[i]; j++) {
                    sb.append(i);
                }
            }
            return sb.toString();
        } else if (sum3 != 0) {
            //вывести все тройки
            StringBuilder sb = new StringBuilder(mod3);
            for (int i = 9; i >= 0; i -= 3) {
                for (int j = 0; j < counted[i]; j++) {
                    sb.append(i);
                }
            }
            return sb.toString();
        } else if (counted[0] != 0) {
            return "0";
        } else return "";
    }
}
