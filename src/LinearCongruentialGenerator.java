
public class LinearCongruentialGenerator {

    private int m, a, c, i;

    public LinearCongruentialGenerator(int modulo, int multiplier, int increment, int seed) {
        this.m = modulo;
        this.a = multiplier;
        this.c = increment;
        this.i = seed;
    }

    public int randomNumber() {
        i = (a * i + c) % m;
        return i;
    }

    public static void main(String[] args) {
        LinearCongruentialGenerator lcg = new LinearCongruentialGenerator(64, 5, 12, 55);
        for (int i = 0; i < 100; i++) {
            System.out.println(lcg.randomNumber());
        }
    }
}