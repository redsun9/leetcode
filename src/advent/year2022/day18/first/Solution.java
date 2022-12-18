package advent.year2022.day18.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

@SuppressWarnings({"DuplicatedCode"})
public class Solution {

    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day18/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day18/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            HashSet<Point> set = new HashSet<>();
            while (scanner.hasNextLine()) {
                String[] split = scanner.nextLine().trim().split(",");
                set.add(new Point(
                        Integer.parseInt(split[0]),
                        Integer.parseInt(split[1]),
                        Integer.parseInt(split[2])
                ));
            }
            int ans = 6 * set.size();
            for (Point point : set) {
                if (set.contains(point.dx(-1))) ans--;
                if (set.contains(point.dy(-1))) ans--;
                if (set.contains(point.dz(-1))) ans--;
                if (set.contains(point.dx(+1))) ans--;
                if (set.contains(point.dy(+1))) ans--;
                if (set.contains(point.dz(+1))) ans--;
            }
            printer.println(ans);
        }
    }

    private record Point(int x, int y, int z) {
        Point dx(int dx) {
            return new Point(this.x + dx, this.y, this.z);
        }

        Point dy(int dy) {
            return new Point(this.x, this.y + dy, this.z);
        }

        Point dz(int dz) {
            return new Point(this.x, this.y, this.z + dz);
        }
    }
}
