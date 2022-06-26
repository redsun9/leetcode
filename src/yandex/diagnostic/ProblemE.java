package yandex.diagnostic;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class ProblemE {
    public static void main(String[] args) throws IOException {
        Reader reader = new Reader();
        int userLimit = reader.nextInt(), serviceLimit = reader.nextInt(), duration = reader.nextInt();
        Deque<Integer> serviceQueue = new ArrayDeque<>(serviceLimit);
        HashMap<Integer, Deque<Integer>> userMap = new HashMap<>();
        int userId, timestamp = reader.nextInt(), threshold, ans;
        while (timestamp != -1) {
            ans = 200;
            userId = reader.nextInt();
            threshold = timestamp - duration;
            Deque<Integer> userQueue = userMap.get(userId);
            while (!serviceQueue.isEmpty() && serviceQueue.peekFirst() < threshold) serviceQueue.pollFirst();
            if (serviceQueue.size() >= serviceLimit) ans = 503;

            if (userQueue != null) {
                while (!userQueue.isEmpty() && userQueue.peekFirst() < threshold) userQueue.pollFirst();
                if (userQueue.size() >= userLimit) ans = 429;
            }
            if (ans == 200) {
                if (userQueue == null) {
                    userQueue = new ArrayDeque<>();
                    userMap.put(userId, userQueue);
                }
                userQueue.offerLast(timestamp);
                serviceQueue.offerLast(timestamp);
            }

            System.out.println(ans);
            System.out.flush();
            timestamp = reader.nextInt();
        }
        reader.close();
    }


    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
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
