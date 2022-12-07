package advent.year2022.day7.first;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

@SuppressWarnings({"WrapperTypeMayBePrimitive", "DuplicatedCode"})
public class Solution {
    public static void main(String[] args) throws IOException {
        try (
                FileInputStream fis = new FileInputStream("src/advent/year2022/day7/first/input.txt");
                Scanner scanner = new Scanner(fis);
                FileOutputStream fos = new FileOutputStream("src/advent/year2022/day7/first/output.txt");
                PrintStream printer = new PrintStream(fos)
        ) {
            FileTreeNode root = new FileTreeNode("/", true, null);
            FileTreeNode curDir = root;
            while (scanner.hasNextLine()) {
                FileTreeNode finalCurDir = curDir;
                String[] parts = scanner.nextLine().trim().split(" ");
                if (parts[0].equals("$")) {
                    if (parts[1].equals("ls")) continue;
                    String dir = parts[2];
                    switch (dir) {
                        case "/" -> curDir = root;
                        case ".." -> curDir = curDir.parent;
                        default ->
                                curDir = curDir.children.computeIfAbsent(dir, name -> new FileTreeNode(name, true, finalCurDir));
                    }
                } else if (parts[0].equals("dir"))
                    curDir.children.computeIfAbsent(parts[1], name -> new FileTreeNode(name, true, finalCurDir));
                else
                    curDir.children.computeIfAbsent(parts[1], name -> new FileTreeNode(name, false, finalCurDir, Long.parseLong(parts[0])));
            }

            long ans = 0;
            Stack<FileTreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()) {
                FileTreeNode node = stack.peek();
                if (!node.computedSize) {
                    for (FileTreeNode child : node.children.values()) stack.push(child);
                    node.computedSize = true;
                } else {
                    stack.pop();
                    for (FileTreeNode child : node.children.values()) node.size += child.size;
                    if (node.directory && node.size <= 100_000) ans += node.size;
                }
            }
            printer.println(ans);
        }
    }

    private static class FileTreeNode {
        final String name;
        final boolean directory;
        boolean computedSize;
        long size;
        final FileTreeNode parent;
        HashMap<String, FileTreeNode> children = new HashMap<>();

        private FileTreeNode(String name, boolean directory, FileTreeNode parent) {
            this.name = name;
            this.directory = directory;
            this.parent = parent;
            this.computedSize = false;
        }

        private FileTreeNode(String name, boolean directory, FileTreeNode parent, long size) {
            this.name = name;
            this.directory = directory;
            this.parent = parent;
            this.size = size;
            this.computedSize = true;
        }
    }
}
