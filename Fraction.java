public final class Fraction implements Comparable<Fraction> {

    private final int numerator;
    private final int denominator;

    private Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero");
        }
        int gcd = gcd(numerator, denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    public static Fraction of(int numerator, int denominator) {
        return new Fraction(numerator, denominator);
    }

    public Fraction add(Fraction fraction) {
        return of(
                (this.numerator * fraction.denominator) + (this.denominator * fraction.numerator),
                this.denominator * fraction.denominator
        );
    }

    public Fraction subtract(Fraction fraction) {
        return of(
                (this.numerator * fraction.denominator) - (this.denominator * fraction.numerator),
                this.denominator * fraction.denominator
        );
    }

    public Fraction multiply(Fraction fraction) {
        return of(this.numerator * fraction.numerator, this.denominator * fraction.denominator);
    }

    public Fraction divide(Fraction fraction) {
        return of(this.numerator * fraction.denominator, this.denominator * fraction.numerator);
    }

    public Fraction reciprocal() {
        return of(this.denominator, this.numerator);
    }

    public double toReal() {
        return (double) this.numerator / this.denominator;
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    @Override
    public int compareTo(Fraction other) {
        return Integer.compare(this.numerator * other.denominator, this.denominator * other.numerator);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !(other instanceof Fraction)) {
            return false;
        }
        Fraction that = (Fraction) other;
        return this.numerator == that.numerator && this.denominator == that.denominator;
    }

    @Override
    public int hashCode() {
        return (this.numerator * 31) + this.denominator;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Fraction fraction1 = Fraction.of(1, 2);
        Fraction fraction2 = Fraction.of(3, 4);

        Fraction sum = fraction1.add(fraction2);
        System.out.println("Sum: " + sum);

        Fraction difference = fraction1.subtract(fraction2);
        System.out.println("Difference: " + difference);

        Fraction product = fraction1.multiply(fraction2);
        System.out.println("Product: " + product);

        Fraction quotient = fraction1.divide(fraction2);
        System.out.println("Quotient: " + quotient);

        Fraction reciprocal = fraction1.reciprocal();
        System.out.println("Reciprocal of fraction1: " + reciprocal);

        double realValue = fraction1.toReal();
        System.out.println("Real value of fraction1: " + realValue);
    }
}
