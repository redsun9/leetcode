package basic;

public class ComplexDouble {
    public static final ComplexDouble PI_HALF = new ComplexDouble(Math.PI / 2, 0);
    public static ComplexDouble ONE = new ComplexDouble(1, 0);
    public static ComplexDouble ZERO = new ComplexDouble(0, 0);
    public static ComplexDouble I = new ComplexDouble(0, 1);

    private double real;
    private double imaginary;

    public ComplexDouble(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexDouble add(ComplexDouble other) {
        return new ComplexDouble(real + other.real, imaginary + other.imaginary);
    }

    public ComplexDouble add(double other) {
        return new ComplexDouble(real + other, imaginary);
    }

    public ComplexDouble subtract(ComplexDouble other) {
        return new ComplexDouble(real - other.real, imaginary - other.imaginary);
    }

    public ComplexDouble subtract(double other) {
        return new ComplexDouble(real - other, imaginary);
    }

    public ComplexDouble multiply(ComplexDouble other) {
        return new ComplexDouble(real * other.real - imaginary * other.imaginary, real * other.imaginary + imaginary * other.real);
    }

    public ComplexDouble multiply(double other) {
        return new ComplexDouble(real * other, imaginary * other);
    }

    public ComplexDouble divide(ComplexDouble other) {
        double v = other.real * other.real + other.imaginary * other.imaginary;
        return new ComplexDouble((real * other.real + imaginary * other.imaginary) / v, (imaginary * other.real - real * other.imaginary) / v);
    }

    public ComplexDouble divide(double other) {
        return new ComplexDouble(real / other, imaginary / other);
    }

    public ComplexDouble conjugate() {
        return new ComplexDouble(real, -imaginary);
    }

    public ComplexDouble binPow(int n) {
        ComplexDouble res = ONE;
        ComplexDouble tmp = this;
        while (n != 0) {
            if ((n & 1) != 0)
                res = res.multiply(tmp);
            tmp = tmp.multiply(tmp);
            n >>= 1;
        }
        return res;
    }

    public ComplexDouble pow(double n) {
        if (n == 0) return ONE;
        if (n == 1) return this;
        if (this.equals(ZERO)) return ZERO;
        if (this.equals(ONE)) return ONE;
        if (n < 0) return ONE.divide(this.pow(-n));
        double r = Math.pow(Math.hypot(real, imaginary), n);
        double theta = Math.atan2(imaginary, real) * n;
        return new ComplexDouble(r * Math.cos(theta), r * Math.sin(theta));
    }

    public ComplexDouble pow(ComplexDouble n) {
        if (n.equals(ZERO)) return ONE;
        if (n.equals(ONE)) return this;
        if (this.equals(ZERO)) return ZERO;
        if (this.equals(ONE)) return ONE;
        return this.log().multiply(n).exp();
    }

    public ComplexDouble exp() {
        double r = Math.exp(real);
        double theta = imaginary;
        return new ComplexDouble(r * Math.cos(theta), r * Math.sin(theta));
    }

    public ComplexDouble log() {
        double r = Math.log(Math.hypot(real, imaginary));
        double theta = Math.atan2(imaginary, real);
        return new ComplexDouble(r, theta);
    }

    public ComplexDouble sqrt() {
        double r = Math.sqrt(Math.hypot(real, imaginary));
        double theta = Math.atan2(imaginary, real) / 2;
        return new ComplexDouble(r * Math.cos(theta), r * Math.sin(theta));
    }

    public ComplexDouble sin() {
        return new ComplexDouble(Math.sin(real) * Math.cosh(imaginary), Math.cos(real) * Math.sinh(imaginary));
    }

    public ComplexDouble cos() {
        return new ComplexDouble(Math.cos(real) * Math.cosh(imaginary), -Math.sin(real) * Math.sinh(imaginary));
    }

    public ComplexDouble tan() {
        return sin().divide(cos());
    }

    public ComplexDouble asin() {
        // i * log(sqrt(1 - z^2) - iz)
        return I.multiply((ONE.subtract(this.multiply(this))).sqrt().subtract(I.multiply(this)).log());
    }

    public ComplexDouble acos() {
        // -i * log(z + sqrt(1 - z^2)) = pi/2 - asin(z)
        return PI_HALF.subtract(asin());
    }

    public ComplexDouble atan() {
        // i/2 * log((i + z) / (i - z))
        return I.divide(2).multiply((I.add(this)).divide(I.subtract(this)).log());
    }

    public ComplexDouble sinh() {
        return new ComplexDouble(Math.sinh(real) * Math.cos(imaginary), Math.cosh(real) * Math.sin(imaginary));
    }

    public ComplexDouble cosh() {
        return new ComplexDouble(Math.cosh(real) * Math.cos(imaginary), Math.sinh(real) * Math.sin(imaginary));
    }

    public ComplexDouble tanh() {
        return sinh().divide(cosh());
    }

    public ComplexDouble asinh() {
        // log(z + sqrt(z^2 + 1))
        return this.add(this.multiply(this).add(ONE).sqrt()).log();
    }

    public ComplexDouble acosh() {
        // log(z + sqrt(z^2 - 1))
        return this.add(this.multiply(this).subtract(ONE).sqrt()).log();
    }

    public ComplexDouble atanh() {
        // log((1 + z) / (1 - z)) / 2
        return (ONE.add(this).divide(ONE.subtract(this))).log().divide(2);
    }

    public String toString() {
        if (imaginary == 0) return real + "";
        if (real == 0) return imaginary + "i";
        if (imaginary < 0) return real + " - " + (-imaginary) + "i";
        return real + " + " + imaginary + "i";
    }
}
