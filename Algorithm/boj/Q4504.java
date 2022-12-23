package boj;

import java.util.Scanner;

public class Q4504 {
    public static void main(String[] args) {
        int multipleNum;
        Scanner sc = new Scanner(System.in);
        FindMultiple findMultiple = new FindMultiple();

        findMultiple.num = sc.nextInt();
        while (true) {
            multipleNum = sc.nextInt();


            findMultiple.FunctionFindMultiple(multipleNum);
        }
    }
}

class FindMultiple {
    int num;

    public boolean FunctionFindMultiple(int multipleNum) {
        if (multipleNum == 0) {
            return false;
        }
        if (multipleNum % num == 0) {
            System.out.println(multipleNum + " is a multiple of " + num + ".");
            return false;
        }

        if (multipleNum % num != 0) {
            System.out.println(multipleNum + " is NOT a multiple of " + num + ".");
            return false;
        }
        return true;

    }


}
