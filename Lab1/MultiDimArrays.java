package Lab1;

public class MultiDimArrays {
    public static void main(String[] args) {
        int[][] array = new int[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                array[i][j] = (int)(Math.random() * 10);

        printArray(array);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <= i; j++) {
                int t = array[i][j];
                array[i][j] = array[j][i];
                array[j][i] = t;
            }
        }

        printArray(array);
    }

    private static void printArray(int[][] a) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}