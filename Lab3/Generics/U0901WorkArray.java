package Lab3.Generics;

public class U0901WorkArray <T extends Number> {
    private T[] arrNums;

    public U0901WorkArray(T[] numP) {
        arrNums = numP;
    }

    public double sum() {
        double work = 0;
        for (T num : arrNums) {
            work += num.doubleValue();
        }

        return work;
    }
}
