import java.util.Scanner;

public class Q1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();
        FindFactorialNumOfZero findFactorialNumOfZero = new FindFactorialNumOfZero(inputNum);
        int numOfZero = findFactorialNumOfZero.divide5ForFindFactorialNum();
        System.out.println(numOfZero);


    }
}

class FindFactorialNumOfZero {
    private static final int toFindFive = 5;
    private int numOfZero;
    private int inputNum;

    FindFactorialNumOfZero(int inputNum) {
        this.inputNum = inputNum;
    }

    int divide5ForFindFactorialNum() {
        for (int i = toFindFive; i < this.inputNum; i *= toFindFive) {
            this.numOfZero += inputNum / i;
        }
        return this.numOfZero;
    }
}
