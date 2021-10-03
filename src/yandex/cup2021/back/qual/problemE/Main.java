package yandex.cup2021.back.qual.problemE;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unchecked")
public class Main {
    private static final byte[] buffer = {
            'i',                        //0
            ',',
            'y', 'y', 'y', 'y',         //2
            '-',
            'm', 'm',                   //7
            '-',
            'd', 'd',                   //10
            ' ',
            'y', 'y', 'y', 'y',         //13
            '-',
            'm', 'm',                   //18
            '-',
            'd', 'd',                   //21
            ',',
            'O', 'T', 'H', 'E', 'R',    //24
            '\n'
    };

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/yandex/cup2021/back/qual/problemE/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/yandex/cup2021/back/qual/problemE/output.txt")
        ) {
            List<LogMessage>[][] lists = new List[10][3];
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 3; j++) {
                    lists[i][j] = new ArrayList<>();
                }
            }
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                LogMessage logMessage = new LogMessage(s);
                int type = gt(s.charAt(24));
                for (int i = 0; i < 3; i++) {
                    if (i == type || type == 3) lists[s.charAt(0) - '0'][i].add(logMessage);
                }
            }


            for (int i = 0; i < 10; i++) {
                buffer[0] = (byte) ('0' + i);
                for (int type = 0; type < 3; type++) {
                    List<LogMessage> list = lists[i][type];
                    if (list.isEmpty()) continue;
                    if (type == 0) {
                        buffer[24] = 'K';
                        buffer[25] = 'G';
                        buffer[26] = 'T';
                        buffer[27] = '\n';
                    } else if (type == 1) {
                        buffer[24] = 'C';
                        buffer[25] = 'O';
                        buffer[26] = 'L';
                        buffer[27] = 'D';
                        buffer[28] = '\n';
                    } else {
                        buffer[24] = 'O';
                        buffer[25] = 'T';
                        buffer[26] = 'H';
                        buffer[27] = 'E';
                        buffer[28] = 'R';
                        buffer[29] = '\n';
                    }
                    list.sort(Comparator.comparingInt(x -> x.startTime));

                    int startTime = -1, endTime = -1;

                    for (LogMessage poll : list) {
                        if (startTime != -1 && endTime < poll.startTime) print(fos, type, startTime, endTime);
                        if (startTime == -1 || endTime < poll.startTime) startTime = poll.startTime;
                        if (endTime < poll.endTime) endTime = poll.endTime;
                    }
                    print(fos, type, startTime, endTime);
                }
            }
        }
    }


    private static void print(FileOutputStream fos, int type, int startTime, int endTime) throws IOException {
        int sy = startTime >>> 9;
        buffer[5] = (byte) ('0' + sy % 10);
        sy /= 10;
        buffer[4] = (byte) ('0' + sy % 10);
        sy /= 10;
        buffer[3] = (byte) ('0' + sy % 10);
        sy /= 10;
        buffer[2] = (byte) ('0' + sy % 10);

        int sm = startTime >>> 5 & 0b1111;
        buffer[8] = (byte) ('0' + sm % 10);
        sm /= 10;
        buffer[7] = (byte) ('0' + sm % 10);

        int sd = startTime & 0b11111;
        buffer[11] = (byte) ('0' + sd % 10);
        sd /= 10;
        buffer[10] = (byte) ('0' + sd % 10);


        int ey = endTime >>> 9;
        buffer[16] = (byte) ('0' + ey % 10);
        ey /= 10;
        buffer[15] = (byte) ('0' + ey % 10);
        ey /= 10;
        buffer[14] = (byte) ('0' + ey % 10);
        ey /= 10;
        buffer[13] = (byte) ('0' + ey % 10);

        int em = endTime >>> 5 & 0b1111;
        buffer[19] = (byte) ('0' + em % 10);
        em /= 10;
        buffer[18] = (byte) ('0' + em % 10);

        int ed = endTime & 0b11111;
        buffer[22] = (byte) ('0' + ed % 10);
        ed /= 10;
        buffer[21] = (byte) ('0' + ed % 10);
        fos.write(buffer, 0, 28 + type);
    }

    private static class LogMessage {
        int startTime, endTime;

        public LogMessage(String s) {
            int sy = s.charAt(2) * 1000 + s.charAt(3) * 100 + s.charAt(4) * 10 + s.charAt(5) - 48 * 1111;
            int sm = s.charAt(7) * 10 + s.charAt(8) - 48 * 11;
            int sd = s.charAt(10) * 10 + s.charAt(11) - 48 * 11;

            int ey = s.charAt(13) * 1000 + s.charAt(14) * 100 + s.charAt(15) * 10 + s.charAt(16) - 48 * 1111;
            int em = s.charAt(18) * 10 + s.charAt(19) - 48 * 11;
            int ed = s.charAt(21) * 10 + s.charAt(22) - 48 * 11;

            this.startTime = sd | sm << 5 | sy << 9;
            this.endTime = ed | em << 5 | ey << 9;
        }
    }

    private static int gt(char c) {
        if (c == 'K') return 0;
        if (c == 'C') return 1;
        if (c == 'O') return 2;
        else return 3;
    }
}
