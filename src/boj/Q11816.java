package boj;

import java.util.Scanner;
/*
정수 X가 주어진다. 정수 X는 항상 8진수, 10진수, 16진수 중에 하나이다.

8진수인 경우에는 수의 앞에 0이 주어지고, 16진수인 경우에는 0x가 주어진다.

X를 10진수로 바꿔서 출력하는 프로그램을 작성하시오.
 */

public class Q11816 {


    public static void main(String[] args) {
        final char OctNum = '0';
        final char HexNum = 'x';


        Scanner sc = new Scanner(System.in);
        String num = sc.next();

        Calculator calculator = new Calculator();

        if (calculator.getFirstDigit(num) == OctNum && calculator.getSecondDigit(num) != HexNum) {
            calculator.getOct(num);
        }
        if (calculator.getFirstDigit(num) == OctNum && calculator.getSecondDigit(num) == HexNum) {
            calculator.getHex(num);
        }
        if (calculator.getFirstDigit(num) != OctNum && calculator.getSecondDigit(num) != HexNum) {
            System.out.println(calculator.getDec(num));
        }

    }
}

class Calculator {

    Calculator() {
    }

    char getFirstDigit(String num) {
        return ("" + num).charAt(0);
    }

    char getSecondDigit(String num) {
        return ("" + num).charAt(1);
    }

    String getDec(String num) {
        return num;
    }

    void getOct(String num) {
        String oct = num.substring(1);
        System.out.println(Integer.valueOf(oct, 8));
    }

    void getHex(String num) {
        String hex = num.substring(2);
        System.out.println(Integer.valueOf(hex, 16));
    }

}
