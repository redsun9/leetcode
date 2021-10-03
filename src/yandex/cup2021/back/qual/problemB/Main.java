package yandex.cup2021.back.qual.problemB;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {

        Reader reader = new Reader("src/yandex/cup2021/back/qual/problemB/input.txt");

        int n = reader.nextInt();

        int m = 0;

        int[] d = new int[n], p = new int[n];
        for (int i = 0; i < n; i++) d[i] = reader.nextInt();

        for (int i = 0; i < n; i++) {
            p[i] = reader.nextInt() - 1;
            if (p[i] == -1) m++;
        }

        int k = reader.nextInt();

        boolean[] fail = new boolean[n];


        if (k > 0) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < k; i++) set.add(reader.nextInt());

            for (int i = 0; i < n; i++) {
                if (set.contains(d[i])) {
                    int tmp = i;
                    while (tmp != -1 && !fail[tmp]) {
                        fail[tmp] = true;
                        tmp = p[tmp];
                        if (tmp == -1) m--;
                    }
                }
            }
        }

        System.out.println(m);
        StringBuilder sb = new StringBuilder(m * 7);

        for (int i = 0; i < n; i++) {
            if (p[i] == -1 && !fail[i]) {
                sb.append(i + 1).append(' ');
            }
        }
        System.out.println(sb);
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            din.close();
        }
    }
}
