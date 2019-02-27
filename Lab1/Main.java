 public class Main{
    public static void main(String[] args){
        System.out.println("Starting project");

        byte v_byte = 120;
        short v_short = 129;
        // Была ошибка: нужно было взять символ в кавычки
        char v_char = 'a';
        int v_int = 65999;
        // Была ошибка: нужно было указать литеру "L"
        long v_long = 4294967296L;
        // Была ошибка: нужно было указать литеру "f"
        float v_float = 0.33333334f;
        double v_double = 0.3333333333333333;
        // Была ошибка: нужно было указать имя v_bool вместо v_double
        boolean v_bool = true;
        
        System.out.println("This is a Byte variable:    " + v_byte);
        System.out.println("This is a Short variable:   " + v_short);
        System.out.println("This is a Char variable:    " + v_char);
        System.out.println("This is a Integer variable: " + v_int);
        System.out.println("This is a Long variable:    " + v_long);
        System.out.println("This is a Float variable:   " + v_float);
        System.out.println("This is a Double variable:  " + v_double);
        System.out.println("This is a Boolean variable: " + v_bool);
    }
}