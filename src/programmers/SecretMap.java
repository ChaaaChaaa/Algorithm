package programmers;

import java.util.Arrays;

public class SecretMap {
    private static final char WALL_Binary = '1';
    private static final char WALL_PRINT = '#';
    private static final String BLANK =" ";
    private static final String initResult ="";

    public static void main(String[] args) {
        int n = 6;
        int [] arr1 = {46, 33, 33 ,22, 31, 50};
        int [] arr2 = {27 ,56, 19, 14, 14, 10};
        System.out.println(Arrays.toString(solution(n,arr1,arr2)));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String [] answer = new String[n];


        for(int i=0; i<n; i++){
            int num = arr1[i] | arr2[i];
            String convertBinary = Integer.toBinaryString(num);
            StringBuilder sb = new StringBuilder();
            for(int k=0; k<convertBinary.length(); k++){
                if (convertBinary.charAt(k) == WALL_Binary) {
                    sb.append(WALL_PRINT);
                }
                else {
                    sb.append(BLANK);
                }
            }

            for(int l =0; l<n-convertBinary.length(); l++){ //앞에 값이 빈칸일경우
                sb.insert(0,BLANK);
            }

            //System.out.println(rowResult);
            answer[i] = sb.toString();
        }
        return answer;
    }

}


