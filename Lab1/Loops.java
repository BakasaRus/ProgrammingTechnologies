import java.util.Date;

public class Loops {
    public static void main(String[] args) {
        // Loop 1
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c);
        }
        System.out.println();

        // Loop 2
        long begin = new Date().getTime();
        for (int i = 0; i < 100000000; i++) {}
        long end = new Date().getTime();
        System.out.printf("Time elapsed: %d ms\n", end - begin);

    }
}