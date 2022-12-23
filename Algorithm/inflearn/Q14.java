package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q14 {
    public int q14(int [] studentNums){
        int ans=1;
        int max = studentNums[0];

        for(int i=0; i<studentNums.length; i++){
            if(studentNums[i] > max){
                ans++;
                max = studentNums[i];
            }
        }

        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int studentNum = sc.nextInt();
        int [] students = new int[studentNum];
        for(int student = 0; student<studentNum; student++){
            students[student] = sc.nextInt();
        }

        Q14 q14 = new Q14();
        System.out.println(q14.q14(students));
    }
}
