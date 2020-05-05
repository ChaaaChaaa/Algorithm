package boj;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2529 {
    private static final int startNumber = 0;
    private static final int maxLength = 20;
    private static final String initString = "";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[] inequalitySignArr = new char[maxLength];

        for (int i = startNumber; i < n; i++) {
            inequalitySignArr[i] = sc.next().toCharArray()[0];
        }


        InequalitySign inequalitySign = new InequalitySign(inequalitySignArr, n);
        inequalitySign.recursion(startNumber, initString);
        System.out.println(inequalitySign.printTheBiggestNum());
        System.out.println(inequalitySign.printTheSmallestNum());


    }
}

class InequalitySign {
    private static final char isLessThan = '<';
    private static final char isGreaterThan = '>';
    private static final char toChangeIntToChar = '0';
    private static final int numOfZeroToNine = 10;
    private static final int nextNumber = 1;
    private static final int beforeNumber = 1;
    private static final int startNumber = 0;
    private static final int lastNumber = 9;

    private char[] inequalitySignArr;
    private int n;

    InequalitySign(char[] inequalitySignArr, int n) {
        this.inequalitySignArr = inequalitySignArr;
        this.n = n;
    }

    private boolean[] isUsedNumber = new boolean[numOfZeroToNine];

    private boolean isRightInequalityEquation(char x, char y, char op) {
        if (op == isLessThan) {
            if (x > y) {
                return false;
            }
        }

        if (op == isGreaterThan) {
            return x >= y;
        }

        return true;
    }


    private ArrayList<String> resultArrayList = new ArrayList<>();

    void recursion(int index, String inequalityEquation) {
        if (index == n + nextNumber) {
            resultArrayList.add(inequalityEquation);
            return;
        }

        for (int i = startNumber; i <= lastNumber; i++) {
            if (isUsedNumber[i]) {
                continue;
            }

            if (index == startNumber || compareBeforeAndNextNum(index, inequalityEquation, i)) {
                isUsedNumber[i] = true;
                recursion(index + nextNumber, inequalityEquation + i);
                isUsedNumber[i] = false;
            }
        }
    }

    private boolean compareBeforeAndNextNum(int index, String num, int i) {
        return isRightInequalityEquation(num.charAt(index - beforeNumber), (char) (i + toChangeIntToChar), inequalitySignArr[index - beforeNumber]);
    }

    String printTheBiggestNum() {
        int resultArrayListSize = resultArrayList.size();
        return resultArrayList.get(resultArrayListSize - beforeNumber);
    }

    String printTheSmallestNum() {
        return resultArrayList.get(startNumber);
    }
}
