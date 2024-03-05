import java.util.TreeSet;

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
        Fraction lowerBound = Fraction.of(4, 11);
        Fraction upperBound = Fraction.of(18, 10);

        int x = 5257;

        TreeSet<Fraction> fractions = new TreeSet<>();

        for (int numerator = 1; numerator < x; numerator++) {
            for (int denominator = numerator + 1; denominator <= x; denominator++) {
                fractions.add(Fraction.of(numerator, denominator));
            }
        }

        int count = 0;
        for (Fraction fraction : fractions) {
            if (fraction.compareTo(lowerBound) > 0 && fraction.compareTo(upperBound) < 0) {
                count++;
            }
        }

        System.out.println(count);
        System.out.println(java.time.Instant.now());
    }
}