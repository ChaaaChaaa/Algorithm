package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q13 {
    public ArrayList<Integer> q13(int num,int [] nums){
        ArrayList<Integer> arrayList = new ArrayList<>();

        arrayList.add(nums[0]);
        for(int i=1; i<nums.length; i++){
            if(nums[i] > nums[i-1]){
                arrayList.add(nums[i]);
            }
        }
        return arrayList;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int [] nums = new int[num];
        for(int n =0; n<num; n++){
            nums[n] = sc.nextInt();
        }

        Q13 q13 = new Q13();
        for(int x : q13.q13(num,nums)){
            System.out.print(x+" ");
        }
    }
}
