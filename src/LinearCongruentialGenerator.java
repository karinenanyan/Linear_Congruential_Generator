import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

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

    public static void main(String[] args) throws IOException {
        LinearCongruentialGenerator lcg1 = new LinearCongruentialGenerator(64, 5, 12, 55);
        LinearCongruentialGenerator lcg2 = new LinearCongruentialGenerator(64, 5, 13, 55);

        int[] arrayIncrement1 = new int[100];
        int[] arrayIncrement2 = new int[100];
        for (int i = 0; i < 100; i++) {
            arrayIncrement1[i] = lcg1.randomNumber();
        }

        for (int i = 0; i < 100; i++) {
            arrayIncrement2[i] = lcg2.randomNumber();
        }

        try {
            PrintWriter printWriter = new PrintWriter(new File("Random_Numbers.csv"));

            printWriter.write("Increment1, Increment2");
            printWriter.println();

            for(int i = 0; i < 100; i++) {
                printWriter.write(Integer.toString(arrayIncrement1[i]));
                printWriter.write(",");
                printWriter.write(Integer.toString(arrayIncrement2[i]));
                printWriter.println();

            }

            printWriter.flush();
            printWriter.close();

        } catch (IOException ioException) {

        }


    }
}