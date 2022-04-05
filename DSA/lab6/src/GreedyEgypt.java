import java.util.ArrayList;
import java.util.List;

class GreedyEgypt {

    public static List<Fraction> getEgyptFrac(Fraction fraction) {
        // Return an array of fractions that represent the Egyptian Fractions
        int denominator = fraction.denominator;
        int numerator = fraction.numerator;
        List<Fraction> result = new ArrayList();
        while (true) {
            if (denominator % numerator == 0) {
                denominator = denominator / numerator;
                numerator = 1;
            }

            if (numerator == 1) {
                result.add(new Fraction(numerator, denominator));
                break;
            } else {
                int d = denominator;
                int n = numerator;

                int num = denominator / numerator + 1;
                result.add(new Fraction(1, num));

                denominator = d * num;
                numerator = n * num - d;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(getEgyptFrac(new Fraction(1, 6)));
    }
}

