package advent.day16.second;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.ToLongFunction;

@SuppressWarnings({"DuplicatedCode", "OptionalGetWithoutIsPresent"})
public class Solution {
    private static final boolean debug = true;

    private static final List<ToLongFunction<List<Long>>> functions = List.of(
            (List<Long> list) -> list.stream().mapToLong(x -> x).sum(),
            (List<Long> list) -> list.stream().mapToLong(x -> x).reduce(1L, (a, b) -> a * b),
            (List<Long> list) -> list.stream().mapToLong(x -> x).min().getAsLong(),
            (List<Long> list) -> list.stream().mapToLong(x -> x).max().getAsLong(),
            x -> x.get(0),
            (List<Long> list) -> list.get(0) > list.get(1) ? 1 : 0,
            (List<Long> list) -> list.get(0) < list.get(1) ? 1 : 0,
            (List<Long> list) -> list.get(0).equals(list.get(1)) ? 1 : 0
    );

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/day16/second/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/day16/second/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().trim();
                int n = s.length();
                byte[] arr = new byte[(n + 1) / 2];
                for (int i = 0; i < n; i++) {
                    char c = s.charAt(i);
                    int val;
                    if (c >= '0' && c <= '9') val = c - '0';
                    else val = 10 + c - 'A';
                    arr[i / 2] |= (i & 1) == 0 ? val << 4 : val;
                }
                ResultOfParsing res = new ResultOfParsing();
                long ans = processPacket(arr, res);
                printer.println(ans);
            }
        }
    }


    private static long processPacket(byte[] arr, ResultOfParsing res) {
        int version = nReadBit(arr, res.currentPosition, 3);
        res.currentPosition += 3;

        int typeId = nReadBit(arr, res.currentPosition, 3);
        res.currentPosition += 3;

        if (debug) System.out.println("\t".repeat(res.currentDepth) + "version - " + version + ", type - " + typeId);

        if (typeId == 4) return processLiteralPacket(arr, res);
        else return processOperatorPacket(arr, res, functions.get(typeId));
    }

    private static long processOperatorPacket(
            byte[] arr, ResultOfParsing res,
            ToLongFunction<List<Long>> listToLongFunction
    ) {
        int lengthTypeId = nReadBit(arr, res.currentPosition, 1);
        res.currentPosition += 1;

        List<Long> list = new ArrayList<>();
        if (lengthTypeId == 0) {
            int totalLength = nReadBit(arr, res.currentPosition, 15);
            res.currentPosition += 15;
            int end = res.currentPosition + totalLength;
            if (debug) System.out.println("\t".repeat(res.currentDepth) + "length - " + totalLength);

            res.currentDepth++;
            while (res.currentPosition < end) list.add(processPacket(arr, res));
            res.currentDepth--;
        } else {
            int totalNumber = nReadBit(arr, res.currentPosition, 11);
            res.currentPosition += 11;
            if (debug) System.out.println("\t".repeat(res.currentDepth) + "totalNumber - " + totalNumber);

            res.currentDepth++;
            for (int i = 0; i < totalNumber; i++) list.add(processPacket(arr, res));
            res.currentDepth--;
        }

        return listToLongFunction.applyAsLong(list);
    }

    private static long processLiteralPacket(
            byte[] arr, ResultOfParsing res
    ) {
        long val = 0;
        while (true) {
            int a = nReadBit(arr, res.currentPosition, 5);
            res.currentPosition += 5;
            val = val << 4 | a & 0b1111;
            if ((a & 0b10000) == 0) break;
        }
        if (debug) System.out.println("\t".repeat(res.currentDepth) + "val - " + val);
        return val;
    }

    private static int readBit(byte[] arr, int idx) {
        return arr[idx / 8] >> (7 - idx % 8) & 1;
    }

    private static int nReadBit(byte[] arr, int idx, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) ans = ans << 1 | readBit(arr, idx++);
        return ans;
    }

    private static class ResultOfParsing {
        int currentPosition;
        int currentDepth;
    }
}
