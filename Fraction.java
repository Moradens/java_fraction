public final class Fraction {
        public static void main(String[] args) {
            Fraction a = Fraction.of(8, 7);
            Fraction quarter = Fraction.of(1, 4);

            System.out.println(a.multiply(quarter).toReal());
        }
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

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}