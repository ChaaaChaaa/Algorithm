package test;

import java.util.Scanner;

public class Main_gcd {
    public static void main(String[] args) {
        int val1, val2;
        int r = 1;
        int LCM;

        Scanner sc = new Scanner(System.in);

        System.out.print("첫번째 수를 입력하시오 : ");
        val1 = sc.nextInt();
        System.out.print("두번째 수를 입력하시오 : ");
        val2 = sc.nextInt();

        int tmp1 = val1, tmp2 = val2;//최소공배수를 구하기 위해 입력받은 값 저장
        if (val1 < val2) {//2번째 입력수가 클 경우 큰수를 val1으로 변경
            val1 = tmp2;
            val2 = tmp1;
            System.out.println(val1+", "+val2);
        }

        while (r > 0) {//유클리드 호제법을 이용한 GCD(최대공약수)구하기
            System.out.println(val1+", "+val2);
            r = val1 % val2;
            val1 = val2;
            val2 = r;
        }
        LCM = tmp1 * tmp2 / val1;//LCM(최소공배수)구하기
        System.out.println("GCD(최대공약수) : " + val1);
        System.out.println("LCM(최소공배수) : " + LCM);

    }
}
