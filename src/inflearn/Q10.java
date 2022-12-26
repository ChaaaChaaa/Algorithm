package inflearn;

import java.util.Scanner;

public class Q10 {
    public int[] q10(String str, char c) {
        int[] answer = new int[str.length()];
        int p=1000;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == c){
                p=0;
                answer[i] = p;
            }
            else{
                p++;
                answer[i] = p;
            }
        }

        p=1000;
        for(int i=str.length()-1; i>=0; i--){
            if(str.charAt(i) == c){
                p=0;
            }
            else{
                p++;
                answer[i] = Math.min(answer[i],p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Q10 q10 = new Q10();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for(int n : q10.q10(str,c)){
            System.out.println(n+" ");
        }
    }

}
