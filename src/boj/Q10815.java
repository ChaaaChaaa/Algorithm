package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q10815 {
    private static final int EXIST = 1;
    private static final int NOT_EXIST = 0;
    private static final char BLANK = ' ';
    private static final int MOVE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] myArray = new int[n];

        StringTokenizer st1 = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < n; i++) {
            myArray[i] = Integer.parseInt(st1.nextToken());
        }

        Arrays.sort(myArray);

        int m = Integer.parseInt(bufferedReader.readLine());

        StringBuilder sb = new StringBuilder();

        StringTokenizer st2 = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < m; i++) {
            int card = Integer.parseInt(st2.nextToken());
            boolean res = numberCard(myArray, card);
            if (res) {
                sb.append(EXIST).append(BLANK);
            } else {
                sb.append(NOT_EXIST).append(BLANK);
            }
        }
        System.out.println(sb);
    }

    public static boolean numberCard(int[] myArray, int card) {
        int size = myArray.length;
        int left = 0;
        int right = size - 1;
        while (left<=right){
            int middle = (left+right)/2;

            if(myArray[middle] == card){
                return true;
            }
            else if (myArray[middle] < card){
                left = middle+MOVE;
            }
            else if(myArray[middle] > card){
                right = middle-MOVE;
            }
        }
        return false;
    }
}

