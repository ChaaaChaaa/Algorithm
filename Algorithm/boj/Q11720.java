package boj;

import java.util.Scanner;

public class Q11720 {
    public static void main(String[] args) {
        SumNum sumNum = new SumNum();
        Scanner sc = new Scanner(System.in);
        int countNum = sc.nextInt();
        String num = sc.next();

        sumNum.sumNum(countNum, num);
    }
}

class SumNum {
    int sum = 0;

    public void sumNum(int countNum, String num) {
        for (int i = 0; i < countNum; i++) {
            sum += num.charAt(i) - '0';
        }
        System.out.print(sum);
    }
}
