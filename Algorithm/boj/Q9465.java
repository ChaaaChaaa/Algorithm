package boj;

import java.util.Scanner;

public class Q9465 {
    private static int [][] arr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();


        for(int i=0; i<num; i++){
            int stickerNum = sc.nextInt();

            for(int j=0; j<num; j++){
                for(int k=0; k<stickerNum; k++){
                    arr = new int[num][stickerNum];
                    arr[i][j]= sc.nextInt();
                }
            }
            printArr(arr,stickerNum,num);
        }
    }

    static void printArr(int [][] arr,int stickerNum, int num){
       for(int i=0; i<num; i++){
           for(int j=0; j<stickerNum; j++){
               System.out.print(arr[i][j]+" ");
           }
           System.out.println();
       }
    }
}
