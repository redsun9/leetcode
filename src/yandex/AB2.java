package yandex;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class AB2 {
    public static void main(String[] args) {
        try (
                FileReader fileReader = new FileReader("input.txt");
                Scanner scanner = new Scanner(fileReader);
                FileWriter fileWriter = new FileWriter("output.txt");
                PrintWriter printWriter = new PrintWriter(fileWriter);
        ) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            printWriter.print(a + b);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
