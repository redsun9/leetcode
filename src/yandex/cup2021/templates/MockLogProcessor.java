package yandex.cup2021.templates;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

public class MockLogProcessor {


    private static class LogMessage {

    }

    private static class LogMessageGroup {

    }

    private static class LogAggregateMessage implements Consumer<LogMessage> {
        @Override
        public void accept(LogMessage logMessage) {

        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        try (
                FileInputStream fis = new FileInputStream("src/yandex/cup2021/templates/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/yandex/cup2021/templates/output.txt");
                PrintWriter printer = new PrintWriter(fos);
        ) {
            Map<LogMessageGroup, LogAggregateMessage> aggregates = new HashMap<>();
            Function<LogMessageGroup, LogAggregateMessage> initalizer = group -> new LogAggregateMessage();
            Function<String, LogMessageGroup> idReader = str -> new LogMessageGroup();
            Function<String, LogMessage> messageReader = str -> new LogMessage();
            BiFunction<LogMessageGroup, LogAggregateMessage, String> writer = (k, v) -> "message";


            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                LogMessageGroup group = idReader.apply(s);
                LogMessage message = messageReader.apply(s);
                LogAggregateMessage aggregate = aggregates.computeIfAbsent(group, initalizer);
                aggregate.accept(message);
            }

            Comparator<Map.Entry<LogMessageGroup, LogAggregateMessage>> comparator = Comparator.comparingInt(x -> 0);
            ArrayList<Map.Entry<LogMessageGroup, LogAggregateMessage>> list = new ArrayList<>(aggregates.entrySet());
            list.sort(comparator);

            list.forEach(entry -> printer.write(writer.apply(entry.getKey(), entry.getValue())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
