package Lab3.Generics;

import java.util.Random;

public class U0901Main {
    public static void main(String[] args) {
        Integer intArr[] = {10, 20, 15};
        Float floatArr[] = new Float[5];
        for (int i = 0; i < 5; ++i)
            floatArr[i] = new Random().nextFloat();

        U0901WorkArray insWorkArrayInt = new U0901WorkArray(intArr);
        U0901WorkArray insWorkArrayFloat = new U0901WorkArray(floatArr);

        System.out.println(insWorkArrayInt.sum());
        System.out.println(insWorkArrayFloat.sum());
    }
}
