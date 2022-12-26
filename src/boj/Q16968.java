package boj;

import java.util.Scanner;

public class Q16968 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char [] carN = sc.next().toCharArray();
        int ans = 1;
        for(int i=0; i<carN.length; i++){
            if(i ==0){
                if(carN[i] == 'c'){
                    ans *= 26;
                }
                else{
                    ans *= 10;
                }
            }

            else{
                if(carN[i] == carN[i-1]){
                    if(carN[i] == 'c'){
                        ans *= 25;
                    }
                    else{
                        ans *= 9;
                    }
                }

                else{
                    if(carN[i] == 'c'){
                        ans *= 26;
                    }
                    else{
                        ans *= 10;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
