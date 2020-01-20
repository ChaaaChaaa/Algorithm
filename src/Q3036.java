import java.util.Scanner;

public class Q3036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfCircle = sc.nextInt();
        int[] arr = new int[numOfCircle];

        arr[0] = sc.nextInt();

        for (int i = 1; i < numOfCircle; i++) {
            arr[i] = sc.nextInt();
            Ring ring = new Ring(arr[0], arr[i]);
            ring.compareCircleRadius();
            ring.euclidean_modulus();
            System.out.println(ring.findContractingFountain());
        }
    }
}

class Ring {

    private int inputCircleRadius;
    private int mainCircleRadius;
    private int gcd;
    private int bigNum;
    private int smallNum;
    private int tmp = 1;

    Ring(int mainCircleRadius, int inputCircleRadius) {
        this.mainCircleRadius = mainCircleRadius;
        this.inputCircleRadius = inputCircleRadius;
    }

    void compareCircleRadius() {
        bigNum = Math.max(mainCircleRadius, inputCircleRadius);
        smallNum = Math.min(mainCircleRadius, inputCircleRadius);
    }

    void euclidean_modulus() {
        while (tmp > 0) {
            tmp = bigNum % smallNum;
            bigNum = smallNum;
            smallNum = tmp;
        }
        gcd = bigNum;
    }


    String findContractingFountain() {
        int numerator = mainCircleRadius / gcd;
        int denominator = inputCircleRadius / gcd;
        return numerator + "/" + denominator;
    }
}
