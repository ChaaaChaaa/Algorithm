import java.util.Scanner;

public class Q5086 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2;


        while (true) {
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            new Relation(num1, num2);

        }
    }
}

class Relation {
    private static final String FACTOR = "factor";
    private static final String MULTIPLE = "multiple";
    private static final String NEITHER = "neither";

    Relation(int num1, int num2) {

        if (num2 % num1 == 0) {
            factor();
            return;
        }
        if (num1 % num2 == 0) {
            multiple();
            return;
        }

        if (num2 % num1 != 0 && num1 % num2 != 0) {
            neither();
            return;
        }

        if (num1 == 0 && num2 == 0) {
          //break;

        }


    }


    private void factor() {
        System.out.println(FACTOR);
    }

    private void multiple() {
        System.out.println(MULTIPLE);
    }

    private void neither() {
        System.out.println(NEITHER);
    }


}
