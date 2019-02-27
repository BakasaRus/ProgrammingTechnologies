public class OneDimArrays {
    public static void main(String[] args) {
        int[] array = {12, 43, 12, -65, 778, 123, 32, 76};

        int max = Integer.MIN_VALUE;
        for (int el : array) {
            max = Integer.max(max, el);
        }

        System.out.println(max);
    }
}