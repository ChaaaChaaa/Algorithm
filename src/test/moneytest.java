package test;

import java.text.DecimalFormat;
import java.util.Scanner;

public class moneytest {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        double money = sc.nextInt();
        DecimalFormat dc = new DecimalFormat("###,###,###,###");
        String changeMoney = dc.format(money);
        System.out.println(changeMoney);


    }
}
