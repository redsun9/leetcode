package help_requests.rebus_solver;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BinaryOperator;

public class Solution {
    public static List<String> solve(String[] operands, String result, Operation operation) {
        Map<Character, Integer> usedCharacters = new HashMap<>();
        Set<Character> nonZeroCharacters = new HashSet<>();

        for (String operand : operands) processInput(operand, usedCharacters, nonZeroCharacters);
        processInput(result, usedCharacters, nonZeroCharacters);

        int numberOfUsedCharacters = usedCharacters.size();
        boolean[] canBeZero = new boolean[numberOfUsedCharacters];
        Arrays.fill(canBeZero, true);
        for (Character nonZeroCharacter : nonZeroCharacters) canBeZero[usedCharacters.get(nonZeroCharacter)] = false;

        char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        List<String> ans = new ArrayList<>();
        dfs(0, numberOfUsedCharacters, digits, usedCharacters, canBeZero, operands, result, operation, ans);
        return ans;
    }

    private static void dfs(
            int currentUsedCharacter, int numberOfUsedCharacters, char[] digits,
            Map<Character, Integer> usedCharacters, boolean[] canBeZero,
            String[] operands, String result, Operation operation, List<String> ans
    ) {
        if (currentUsedCharacter == numberOfUsedCharacters) {
            checkAndAddAnswerIfOk(digits, usedCharacters, operands, result, operation, ans);
        } else {
            for (int i = currentUsedCharacter; i < 10; i++) {
                swap(digits, currentUsedCharacter, i);
                if (canBeZero[currentUsedCharacter] || digits[currentUsedCharacter] != '0') {
                    dfs(currentUsedCharacter + 1, numberOfUsedCharacters, digits, usedCharacters, canBeZero, operands, result, operation, ans);
                }
                swap(digits, currentUsedCharacter, i);
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void checkAndAddAnswerIfOk(
            char[] digits, Map<Character, Integer> usedCharacters,
            String[] operands, String result, Operation operation, List<String> ans
    ) {
        BigInteger actual = operation.nullValue;
        BigInteger expected = convert(result, digits, usedCharacters);
        for (String operand : operands) actual = operation.f.apply(actual, convert(operand, digits, usedCharacters));
        if (actual.equals(expected)) createAnswer(digits, usedCharacters, operands, result, operation, ans);
    }

    private static BigInteger convert(String s, char[] digits, Map<Character, Integer> usedCharacters) {
        int n = s.length();
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) ans[i] = digits[usedCharacters.get(s.charAt(i))];
        return new BigInteger(new String(ans));
    }

    private static void createAnswer(
            char[] digits, Map<Character, Integer> usedCharacters,
            String[] operands, String result, Operation operation, List<String> ans
    ) {
        StringBuilder sb = new StringBuilder();
        for (String operand : operands) {
            if (!sb.isEmpty()) sb.append(' ').append(operation.operatorChar).append(' ');
            int n = operand.length();
            for (int i = 0; i < n; i++) sb.append(digits[usedCharacters.get(operand.charAt(i))]);
        }
        sb.append(" = ");
        int m = result.length();
        for (int i = 0; i < m; i++) sb.append(digits[usedCharacters.get(result.charAt(i))]);
        ans.add(sb.toString());
    }

    private static void processInput(String s, Map<Character, Integer> usedCharacters, Set<Character> nonZeroCharacters) {
        int n = s.length();
        if (n > 1) nonZeroCharacters.add(s.charAt(0));
        for (int i = 0; i < n; i++) {
            if (!usedCharacters.containsKey(s.charAt(i))) usedCharacters.put(s.charAt(i), usedCharacters.size());
        }
    }


    public enum Operation {
        MULTIPLICATION(BigInteger::multiply, '*', BigInteger.ONE),
        ADDITION(BigInteger::add, '+', BigInteger.ZERO);

        final BinaryOperator<BigInteger> f;
        final char operatorChar;
        final BigInteger nullValue;

        Operation(BinaryOperator<BigInteger> f, char operatorChar, BigInteger nullValue) {
            this.f = f;
            this.operatorChar = operatorChar;
            this.nullValue = nullValue;
        }
    }
}
