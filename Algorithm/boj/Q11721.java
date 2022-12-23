package boj;

import java.util.Scanner;

public class Q11721 {
    public static void main(String[] args) {
        Split10words split10words;
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int size = str.length();


        for (int i=0; i<size; i++){
            new Split10words(str,i);
        }

    }
}

class Split10words{
    public Split10words(String str, int num){
        char changeNum = str.charAt(num);
        System.out.print(changeNum);
        if(num %10 == 9){
            System.out.println();
        }
    }
}