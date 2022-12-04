package advent.year2021.day16.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {
    private static final boolean debug = true;

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2021/day16/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2021/day16/first/output.txt");
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
                processPacket(arr, res);
                printer.println(res.ans);
            }
        }
    }


    private static void processPacket(byte[] arr, ResultOfParsing res) {
        int version = nReadBit(arr, res.currentPosition, 3);
        res.currentPosition += 3;

        res.ans += version;

        int typeId = nReadBit(arr, res.currentPosition, 3);
        res.currentPosition += 3;

        if (debug) System.out.println("\t".repeat(res.depth) + "version - " + version + ", type - " + typeId);

        if (typeId == 4) processLiteralPacket(arr, res);
        else processOperatorPacket(arr, res);
    }

    private static void processOperatorPacket(
            byte[] arr, ResultOfParsing res
    ) {
        int lengthTypeId = nReadBit(arr, res.currentPosition, 1);
        res.currentPosition += 1;

        if (lengthTypeId == 0) {
            int totalLength = nReadBit(arr, res.currentPosition, 15);
            res.currentPosition += 15;
            int end = res.currentPosition + totalLength;
            if (debug) System.out.println("\t".repeat(res.depth) + "length - " + totalLength);

            res.depth++;
            while (res.currentPosition < end) processPacket(arr, res);
            res.depth--;
        } else {
            int totalNumber = nReadBit(arr, res.currentPosition, 11);
            res.currentPosition += 11;
            if (debug) System.out.println("\t".repeat(res.depth) + "totalNumber - " + totalNumber);

            res.depth++;
            for (int i = 0; i < totalNumber; i++) processPacket(arr, res);
            res.depth--;
        }

    }

    private static void processLiteralPacket(
            byte[] arr, ResultOfParsing res
    ) {
        long val = 0;
        while (true) {
            int a = nReadBit(arr, res.currentPosition, 5);
            res.currentPosition += 5;
            val = val << 4 | a & 0b1111;
            if ((a & 0b10000) == 0) break;
        }
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
        long ans;
        int currentPosition;
        int depth;
    }
}