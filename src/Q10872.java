import java.util.Scanner;

public class Q10872 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int result = 1;
        int num = sc.nextInt();
        Factorial factorial = new Factorial(num);

    }
}

class Factorial {
    Factorial(int num) {
        int result = 1;
        for (int i = num; i > 0; i--) {
            result *= i;
        }
        System.out.println(result);
    }
}