import java.util.Arrays;
import java.util.Scanner;

public class Q3052 {
    private static final int SET_ARRAY_SIZE = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] remainderArr = new int[SET_ARRAY_SIZE];
        Remainder remainder = new Remainder(remainderArr);

        for (int i = 0; i < SET_ARRAY_SIZE; i++) {
            int num = sc.nextInt();
            remainder.divideNumber(i, num);
        }

        remainder.sortArr();
        remainder.convertNumToString();
        remainder.printResult();


    }
}

class Remainder {
    private static final int DIVIDE_NUM = 42;
    private static final int SET_ARRAY_SIZE = 10;
    private int[] remainderArr;
    private String[] remainderString = new String[SET_ARRAY_SIZE];


    Remainder(int[] remainderArr) {
        this.remainderArr = remainderArr;

    }

    void divideNumber(int i, int num) {
        remainderArr[i] = num % DIVIDE_NUM;
    }

    void convertNumToString() {
        String str = "";
        for (int i = 0; i < SET_ARRAY_SIZE; i++) {
            String temp;
            temp = remainderArr[i] + str;
            remainderString[i] = temp;
        }
    }

    void sortArr() {
        Arrays.sort(remainderArr);
    }

    private int compareEachNumber() {
        int count = 0;
        String prevStr = "";
        for (String str : remainderString) {
            if (prevStr.equals(str)) {
                continue;
            }
            count++;
            prevStr = str;
        }
        return count;
    }

    void printResult() {
        System.out.println(compareEachNumber());
    }

}
