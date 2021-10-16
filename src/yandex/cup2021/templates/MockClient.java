package yandex.cup2021.templates;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static java.util.stream.Collectors.toList;

@SuppressWarnings("unchecked")
public class MockClient {
    public void request() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://127.0.0.1:7777?a=12&b=123123"))
                .method("MEW", HttpRequest.BodyPublishers.ofString("1231231312"))
                .header("X-foo", "bar")
                .build();

        System.out.println("1");
        HttpResponse<String> response = httpClient.send(request, ofString());
        System.out.println("Response status - " + response.statusCode());

        HttpHeaders responseHeaders = response.headers();
        System.out.println();
        System.out.println("Headers:");
        responseHeaders.map().forEach((k, v) -> System.out.println("key - " + k + ", value - " + v));
        System.out.println();

        System.out.println("Response body:");
        System.out.println(response.body());
    }

    public String[] getURIs(List<URI> uris) throws ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        List<HttpRequest> requests = uris.stream()
                .map(HttpRequest::newBuilder)
                .map(HttpRequest.Builder::build)
                .collect(toList());

        CompletableFuture<?>[] futures = requests.stream()
                .map(request -> client.sendAsync(request, ofString()))
                .toArray(CompletableFuture<?>[]::new);
        CompletableFuture.allOf(futures).join();

        int n = futures.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) ans[i] = ((CompletableFuture<HttpResponse<String>>) futures[i]).get().body();
        return ans;
    }

    public static void main(String[] args) throws Exception {
        MockClient client = new MockClient();
        client.request();
    }
}
