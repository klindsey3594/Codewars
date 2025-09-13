public class Fraction {
    private final long top;      // numerator
    private final long bottom;   // denominator (always > 0)

    public Fraction(long numerator, long denominator) {
        if (denominator == 0) throw new IllegalArgumentException("Denominator cannot be zero");
        if (denominator < 0) { numerator = -numerator; denominator = -denominator; }
        long g = gcd(Math.abs(numerator), Math.abs(denominator));
        top = numerator / g;
        bottom = denominator / g;
    }

    public Fraction add(Fraction other) {
        long newTop = this.top * other.bottom + other.top * this.bottom;
        long newBottom = this.bottom * other.bottom;
        return new Fraction(newTop, newBottom);
    }

    @Override
    public String toString() {
        return top + "/" + bottom;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Fraction)) return false;
        Fraction f = (Fraction) o;
        return this.top == f.top && this.bottom == f.bottom;
    }

    @Override
    public int hashCode() {
        long h = 31 * top + bottom;
        return (int)(h ^ (h >>> 32));
    }

    private static long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return (a == 0) ? 1 : a;
    }
}
