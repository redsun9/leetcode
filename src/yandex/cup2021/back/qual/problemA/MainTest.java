package yandex.cup2021.back.qual.problemA;

import org.junit.jupiter.api.Test;
import yandex.cup2021.back.qual.problemA.Main.Client;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MainTest {
    @Test
    void test1() throws IOException, InterruptedException {
        String[] k = {"a", "b", "c", "d"};
        String[] v = {"f", "e", "e", "f"};

        Client client = new MockClient(k, v);
        String[] actual = Main.solve(k, client);
        assertArrayEquals(v, actual);
    }


    @Test
    void check() throws IOException, InterruptedException {
        String[] k = {"a", "b", "c", "d"};
        String[] v = {"e", "f", "g", "h"};

        int totalTests = 256;

        String[] expected = new String[4];
        for (int test = 0; test < totalTests; test++) {
            int tmp = test;
            for (int i = 0; i < 4; i++) {
                expected[i] = v[tmp & 3];
                tmp >>>= 2;
            }
            Client client = new MockClient(k, expected);
            String[] actual = Main.solve(k, client);
            try {
                assertArrayEquals(expected, actual);
            } catch (Throwable e) {
                System.out.println(Arrays.toString(expected));
                System.out.println(Arrays.toString(actual));
                throw e;
            }
        }
    }

    @Test
    void checkSolvability() {
        String[] k = {"a", "b", "c", "d"};
        String[] v = {"e", "f", "g", "h"};
        MockClient[] clients = new MockClient[256];
        for (int key = 0; key < 256; key++) {
            String[] expected = {v[key & 3], v[key >>> 2 & 3], v[key >>> 4 & 3], v[key >>> 6 & 3]};
            clients[key] = new MockClient(k, expected);
        }
        List<List<String>> requests = List.of(
                List.of(k[0], k[1], k[2]),
                List.of(k[0], k[1], k[3]),
                List.of(k[1], k[2], k[3])
        );
        HashMap<List<List<String>>, List<Map<String, String>>> countMap = new HashMap<>();
        for (MockClient client : clients) {
            List<List<String>> list = List.of(
                    client.get(requests.get(0)),
                    client.get(requests.get(1)),
                    client.get(requests.get(2))
            );
            countMap.computeIfAbsent(list, key -> new ArrayList<>()).add(client.map);
        }

        for (Map.Entry<List<List<String>>, List<Map<String, String>>> entry : countMap.entrySet()) {
            if (entry.getValue().size() > 1) {
                System.out.println(entry.getKey());
                System.out.println(entry.getValue());
                System.out.println();
            }
        }
    }
}