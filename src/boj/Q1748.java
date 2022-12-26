package boj;

import java.util.Scanner;

public class Q1748 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        AppendNumber1 appendNumber1 = new AppendNumber1(inputNum);
        appendNumber1.crossCheckToEachDigit();
        appendNumber1.printResult();
    }
}

class AppendNumber1 {
    private int inputNum;
    private int result;
    private int end;
    private int digit = 1;

    AppendNumber1(int inputNum) {
        this.inputNum = inputNum;
    }


    void crossCheckToEachDigit() {
        for (int start = 1; start <= inputNum; start *= 10) {

            changeEndValueToInputNum(start);
            countEachDigit(start);
        }
    }

    private void changeEndValueToInputNum(int start) {
        end = start * 10 - 1;
        if (end > inputNum) {
            end = inputNum;
        }
    }

    private void countEachDigit(int start) {
        result += (end - start + 1) * digit;
        digit++;
    }

    void printResult() {
        System.out.println(result);
    }

}