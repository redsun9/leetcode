package yandex.cup2021.back.qual.problemA;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.Flow;

import static yandex.cup2021.back.qual.problemA.Main.P.p;
import static yandex.cup2021.back.qual.problemA.Main.S.a;
import static yandex.cup2021.back.qual.problemA.Main.S.m;

public class Main {
    private static final S strategy = m(
            3,
            11, m(4,
                    1, m(8, 1, a(1111), 2, a(1112)),
                    2, m(8, 1, a(1121), 2, a(1122), 3, a(1123))
            ),
            12, m(13,
                    p(134, m(4, 3, a(1234), 4, a(1243))),
                    p(234, m(4, 3, a(2134), 4, a(2143))),
                    p(111, a(1211)),
                    p(222, a(2122)),
                    p(113, m(4, 1, a(1213), 3, a(1231))),
                    p(223, m(4, 2, a(2123), 3, a(2132))),
                    p(133, a(1233)),
                    p(233, a(2133)),
                    p(112, m(6, 11, a(2111), 12, a(1212), 22, a(1221))),
                    p(122, m(6, 11, a(2112), 12, a(2121), 22, a(1222))),
                    p(123, m(6, 11, a(2113), 13, a(2131), 22, a(1223), 23, a(1232)))
            )
    );

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        String[] k = new String[4];
        for (int i = 0; i < 4; i++) k[i] = scanner.nextLine();
        String[] ans = solve(k, new CustomClient());
        for (String s : ans) {
            System.out.println(s);
        }
    }


    static String[] solve(String[] keys, Client client) throws IOException, InterruptedException {
        Map<String, Integer> seen = new HashMap<>();
        String[] indexToWord = new String[5];
        int numberOfDifferentWords = 0;

        S curr = strategy;
        while (curr.result == 0) {
            List<String> request = new ArrayList<>(Integer.bitCount(curr.move));
            for (int i = 0; i < 4; i++) if ((curr.move >>> i & 1) == 1) request.add(keys[i]);
            List<String> response = client.get(request);
            List<Integer> responseWordIndices = new ArrayList<>(response.size());
            for (String s : response) {
                if (seen.containsKey(s)) responseWordIndices.add(seen.get(s));
                else {
                    numberOfDifferentWords++;
                    seen.put(s, numberOfDifferentWords);
                    indexToWord[numberOfDifferentWords] = s;
                    responseWordIndices.add(numberOfDifferentWords);
                }
            }
            Collections.sort(responseWordIndices);
            int responseKey = 0;
            for (Integer index : responseWordIndices) responseKey = responseKey * 10 + index;
            curr = curr.next.get(responseKey);
        }

        String[] ans = new String[4];
        int ansKey = curr.result;
        for (int i = 3; i >= 0; i--) {
            ans[i] = indexToWord[ansKey % 10];
            ansKey /= 10;
        }
        return ans;
    }


    static class S {
        int result, move;
        Map<Integer, S> next;

        static S a(int ans) {
            return new S(ans, 0, null);
        }

        static S m(int move, int v1, S s1, int v2, S s2) {
            return new S(0, move, Map.of(v1, s1, v2, s2));
        }

        static S m(int move, int v1, S s1, int v2, S s2, int v3, S s3) {
            return new S(0, move, Map.of(v1, s1, v2, s2, v3, s3));
        }

        static S m(int move, int v1, S s1, int v2, S s2, int v3, S s3, int v4, S s4) {
            return new S(0, move, Map.of(v1, s1, v2, s2, v3, s3, v4, s4));
        }

        static S m(int move, P... ps) {
            HashMap<Integer, S> map = new HashMap<>();
            for (P p : ps) map.put(p.res, p.s);
            return new S(0, move, map);
        }


        private S(int result, int move, Map<Integer, S> next) {
            this.result = result;
            this.move = move;
            this.next = next;
        }

    }

    static class P {
        int res;
        S s;

        private P(int res, S s) {
            this.res = res;
            this.s = s;
        }

        static P p(int res, S s) {
            return new P(res, s);
        }
    }

    interface Client {
        List<String> get(List<String> list) throws IOException, InterruptedException;
    }

    static class CustomClient implements Client {
        @Override
        public List<String> get(List<String> list) throws IOException, InterruptedException {
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://127.0.0.1:7777"))
                    .method("MEW", HttpRequest.BodyPublishers.noBody())
                    .header("X-cat-variable", String.join(",", list))
                    .build();

            HttpHeaders headers = httpClient.send(request, responseInfo -> new HttpResponse.BodySubscriber<>() {
                @Override
                public CompletionStage<Object> getBody() {
                    return CompletableFuture.completedFuture(null);
                }

                @Override
                public void onSubscribe(Flow.Subscription subscription) {

                }

                @Override
                public void onNext(List<ByteBuffer> item) {

                }

                @Override
                public void onError(Throwable throwable) {

                }

                @Override
                public void onComplete() {

                }
            }).headers();
            return headers.allValues("X-Cat-Value");
        }
    }
}
