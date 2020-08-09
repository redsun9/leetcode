package other;

import java.util.Scanner;
import java.util.Stack;

public class Html {
    public static final String correct = "CORRECT";
    public static final String incorrect = "INCORRECT";
    public static final String almost = "ALMOST";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < x; t++) {
            int n = Integer.parseInt(scanner.nextLine());
            String errorClosedTag = null;
            Stack<String> openedStack = new Stack<>();
            while (n > 0) {
                n--;
                String s = scanner.nextLine();
                boolean opened = s.charAt(1) != '/';
                String tag = s.substring(opened ? 1 : 2, s.length() - 1).toUpperCase();
                if (opened) {
                    openedStack.push(tag);
                } else {
                    if (!openedStack.isEmpty() && openedStack.peek().equals(tag)) openedStack.pop();
                    else {
                        errorClosedTag = tag;
                        break;
                    }
                }
            }
            if (n == 0 && errorClosedTag == null) {
                if (openedStack.isEmpty()) System.out.println(correct);
                else if (openedStack.size() == 1) System.out.println(almost + "<" + openedStack.pop() + ">");
                else System.out.println(incorrect);
            } else if (n == 0 && errorClosedTag != null) {
                if (openedStack.isEmpty()) System.out.println(almost + "</" + errorClosedTag + ">");
                else if (openedStack.size() == 2) {
                    String errorOpenedTag = openedStack.pop();
                    if (openedStack.pop().equals(errorClosedTag))
                        System.out.println(almost + "<" + errorOpenedTag + ">");
                    else System.out.println(incorrect);
                } else System.out.println(incorrect);
            } else {
                Stack<String> closedStack = new Stack<>();
                closedStack.addAll(openedStack);

                boolean deleteOpenedOk = openedStack.size() >= 2;
                boolean deleteClosedOk = true;
                String errorOpenedTag = null;

                if (deleteOpenedOk) {
                    errorOpenedTag = openedStack.pop();
                    deleteOpenedOk = openedStack.pop().equals(errorClosedTag);
                }

                while ((deleteOpenedOk || deleteClosedOk) && n > 0) {
                    String s = scanner.nextLine();
                    n--;
                    boolean opened = s.charAt(1) != '/';
                    String tag = s.substring(opened ? 1 : 2, s.length() - 1).toUpperCase();
                    if (opened) {
                        if (deleteOpenedOk) openedStack.push(tag);
                        if (deleteClosedOk) closedStack.push(tag);
                    } else {
                        if (deleteOpenedOk && !openedStack.isEmpty() && openedStack.peek().equals(tag))
                            openedStack.pop();
                        else deleteOpenedOk = false;

                        if (deleteClosedOk && !closedStack.isEmpty() && closedStack.peek().equals(tag))
                            closedStack.pop();
                        else deleteClosedOk = false;
                    }
                }

                if (deleteOpenedOk && openedStack.isEmpty()) System.out.println(almost + "<" + errorOpenedTag + ">");
                else if (deleteClosedOk && closedStack.isEmpty())
                    System.out.println(almost + "</" + errorClosedTag + ">");
                else System.out.println(incorrect);
            }
            while (n-- > 0) scanner.nextLine();
        }
    }
}
