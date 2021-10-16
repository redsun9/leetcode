package yandex.cup2021.templates;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpServer;

import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.Scanner;

public class MockServer {

    public void run() throws Exception {
        HttpServer server = HttpServer.create();
        server.bind(new InetSocketAddress(InetAddress.getLoopbackAddress(), 7777), 0);
        server.createContext("/", request -> {
            System.out.println("Request method - " + request.getRequestMethod());
            System.out.println("Protocol - " + request.getProtocol());
            System.out.println("Local address - " + request.getLocalAddress());
            System.out.println("URI - " + request.getRequestURI());

            Map<String, Object> attributes = request.getHttpContext().getAttributes();
            System.out.println("Attributes:");
            attributes.forEach((k, v) -> System.out.println("key - " + k + ", value - " + v));
            System.out.println();

            Headers requestHeaders = request.getRequestHeaders();
            System.out.println();
            System.out.println("Headers:");
            requestHeaders.forEach((k, v) -> System.out.println("key - " + k + ", value - " + v));
            System.out.println();

            System.out.println("Principal: " + request.getPrincipal());

            InputStream requestBody = request.getRequestBody();
            Scanner scanner = new Scanner(requestBody);
            String s = scanner.nextLine();
            System.out.println("request body:");
            System.out.println(s);
            System.out.println();

//            if (badRequest) {
//                request.sendResponseHeaders(400, 0);
//                return;
//            }

            Headers responseHeader = request.getResponseHeaders();
            responseHeader.add("X-Foo", "bar");

            System.out.println("Added response headers");

//            byte[] bytes = "1337".getBytes(StandardCharsets.UTF_8);
//            request.getResponseBody().write(bytes);
//            request.getResponseBody().flush();
//            request.getResponseBody().close();
//            System.out.println("Body written");

//            if (noResponseBody) {
//                request.sendResponseHeaders(200, -1);
//            }
//            responseBody.flush();
//            responseBody.close();
//            System.out.println("Close streams");
            request.sendResponseHeaders(200, 0);
        });

        server.setExecutor(null);
        server.start();
//        server.stop(10);
    }

    public static void main(String[] args) {
        try {
            new MockServer().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
