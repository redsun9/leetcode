package basic.utils;

import java.util.function.DoubleFunction;

@SuppressWarnings("DuplicatedCode")
public class MathTools {
    private static final double phi = (3 - Math.sqrt(5)) / 2;
    private static final double psi = (Math.sqrt(5) - 1) / 2;

    // dichotomy
    public static double findRoot(DoubleFunction<Double> f, double l, double r) {
        boolean sign = f.apply(l) < 0;
        while (true) {
            double mid = (l + r) / 2;
            if (l == mid || r == mid) return l;
            if (f.apply(mid) <= 0 == sign) l = mid;
            else r = mid;
        }
    }

    //Newton method
    public static double findRoot(
            DoubleFunction<Double> f, DoubleFunction<Double> df,
            double xn, double eps
    ) {
        double x1 = xn - f.apply(xn) / df.apply(xn);
        double x0 = xn;
        while (Math.abs(x0 - x1) > eps) {
            x0 = x1;
            x1 = x1 - f.apply(x1) / df.apply(x1);
        }
        return x1;
    }

    public static double findMinimum(DoubleFunction<Double> f, double a, double b) {
        double c = a + phi * (b - a);
        double d = a + psi * (b - a);
        double fc = f.apply(c);
        double fd = f.apply(d);

        while (true) {
            if (a == c || b == d) return (a + b) / 2;
            if (fc < fd) {
                b = d;
                d = c;
                fd = fc;
                c = a + psi * (d - a); //c = a+phi*(b-a)
                fc = f.apply(c);
            } else {
                a = c;
                c = d;
                fc = fd;
                d = b - psi * (b - c); // d = b-phi*(b-a)
                fd = f.apply(d);
            }
        }
    }

    public static double findMaximum(DoubleFunction<Double> f, double a, double b) {
        double c = a + phi * (b - a);
        double d = a + psi * (b - a);
        double fc = f.apply(c);
        double fd = f.apply(d);

        while (true) {
            if (a == c || b == d) return (a + b) / 2;
            if (fc > fd) {
                b = d;
                d = c;
                fd = fc;
                c = a + psi * (d - a); //c = a+phi*(b-a)
                fc = f.apply(c);
            } else {
                a = c;
                c = d;
                fc = fd;
                d = b - psi * (b - c); // d = b-phi*(b-a)
                fd = f.apply(d);
            }
        }
    }
}
