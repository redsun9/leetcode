package yandex.diagnostic;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.function.Function;

@SuppressWarnings("EnhancedSwitchMigration")
public class ProblemB {
    private static final int weekOffset = 8 - LocalDate.ofEpochDay(0).getDayOfWeek().getValue();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] split = scanner.nextLine().trim().split(" +");

        LocalDate startDate = LocalDate.parse(split[0]);
        LocalDate endDate = LocalDate.parse(split[1]);

        Function<LocalDate, Integer> getNumberOfPeriod;
        Function<Integer, LocalDate> getStartOfNthPeriod;

        switch (s) {
            case "WEEK":
                getNumberOfPeriod = ProblemB::getNumberOfWeeks;
                getStartOfNthPeriod = ProblemB::getStartOfNthWeek;
                break;
            case "MONTH":
                getNumberOfPeriod = ProblemB::getNumberOfMonth;
                getStartOfNthPeriod = ProblemB::getStartOfNthMonth;
                break;
            case "QUARTER":
                getNumberOfPeriod = ProblemB::getNumberOfQuarter;
                getStartOfNthPeriod = ProblemB::getStartOfNthQuarter;
                break;
            case "YEAR":
                getNumberOfPeriod = ProblemB::getNumberOfYear;
                getStartOfNthPeriod = ProblemB::getStartOfNthYear;
                break;
            case "REVIEW":
                getNumberOfPeriod = ProblemB::getNumberOfReview;
                getStartOfNthPeriod = ProblemB::getStartOfNthReview;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + s);
        }

        int start = getNumberOfPeriod.apply(startDate), end = getNumberOfPeriod.apply(endDate);
        int n = end - start + 1;
        System.out.println(n);
        if (n == 1) {
            System.out.println(startDate + " " + endDate);
            return;
        }

        System.out.println(startDate + " " + getStartOfNthPeriod.apply(start + 1).minusDays(1));
        for (int i = start + 1; i < end; i++) {
            System.out.println(getStartOfNthPeriod.apply(i) + " " + getStartOfNthPeriod.apply(i + 1).minusDays(1));
        }
        System.out.println(getStartOfNthPeriod.apply(end) + " " + endDate);
    }

    private static int getNumberOfMonth(LocalDate localDate) {
        return localDate.getYear() * 12 + localDate.getMonthValue() - 1;
    }

    private static LocalDate getStartOfNthMonth(int n) {
        return LocalDate.of(n / 12, n % 12 + 1, 1);
    }


    private static int getNumberOfYear(LocalDate localDate) {
        return localDate.getYear();
    }

    private static LocalDate getStartOfNthYear(int n) {
        return LocalDate.of(n, 1, 1);
    }


    private static int getNumberOfQuarter(LocalDate localDate) {
        return localDate.getYear() * 4 + (localDate.getMonthValue() - 1) / 3;
    }

    private static LocalDate getStartOfNthQuarter(int n) {
        return LocalDate.of(n / 4, 1 + n % 4 * 3, 1);
    }


    private static int getNumberOfWeeks(LocalDate localDate) {
        return (int) ((localDate.toEpochDay() - weekOffset) / 7);
    }

    private static LocalDate getStartOfNthWeek(long n) {
        return LocalDate.ofEpochDay(weekOffset + n * 7L);
    }


    private static int getNumberOfReview(LocalDate localDate) {
        int number = localDate.getYear() * 2;
        int month = localDate.getMonthValue();
        if (month <= 3) number--;
        else if (month >= 10) number++;
        return number;
    }

    private static LocalDate getStartOfNthReview(int n) {
        return LocalDate.of(n / 2, n % 2 == 0 ? 4 : 10, 1);
    }
}
