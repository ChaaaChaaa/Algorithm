import java.util.Scanner;

public class Q2231 {
    public static void main(String[] args) {
        DecompositionNum decompositionNum = new DecompositionNum();
        int digit = 1;

        Scanner sc = new Scanner(System.in);
        int inputNum = sc.nextInt();

        digit = decompositionNum.findDigit(inputNum, digit);
        int startNum = decompositionNum.checkRangeDigit(digit, inputNum);
        System.out.println(decompositionNum.findDecompositionNum(startNum, inputNum));


    }
}

class DecompositionNum {

    int findDigit(int inputNum, int digit) {
        int countDigitNum = inputNum;

        while (countDigitNum > 0) {
            countDigitNum = countDigitNum / 10;
            digit++;
        }
        return digit;
    }

    int checkRangeDigit(int digit, int inputNum) {
        return inputNum - (9 * digit);
    }

    private int addDigit(int toDigitNum) {
        int sum = toDigitNum;
        while (toDigitNum != 0) {
            sum += (toDigitNum % 10);
            toDigitNum /= 10;
        }
        return sum;
    }

    int findDecompositionNum(int startNum, int inputNum) {
        for (int i = startNum; i < inputNum; i++) {
            if (inputNum == addDigit(i)) {
                return i;
            }
        }
        return 0;
    }

}
