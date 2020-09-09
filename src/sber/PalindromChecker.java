package sber;

public class PalindromChecker {
    public boolean isPalindrom(String string1, String string2) {
        int n1 = string1.length();
        int n2 = string2.length();

        int i1 = 0, i2 = n2 - 1;
        while (true) {
            while (i1 < n1 && !Character.isLetterOrDigit(string1.charAt(i1))) i1++;
            while (i2 >= 0 && !Character.isLetterOrDigit(string2.charAt(i2))) i2--;
            if (i1 == n1 && i2 == -1) return true;
            if (i1 == n1 || i2 == -1 || string1.charAt(i1) != string2.charAt(i2)) return false;
            i1++;
            i2--;
        }
    }
}
