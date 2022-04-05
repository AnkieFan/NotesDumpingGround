public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public boolean equals(Object o) {
        Fraction other = (Fraction)o;
        return other.numerator == this.numerator && other.denominator == this.denominator;
    }

    public String toString() {
        return numerator + "/" + denominator;
    }
}
