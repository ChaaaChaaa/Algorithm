package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();

        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for(Integer num: list){
            sb.append(num).append('\n');
        }

        System.out.println(sb);
    }
}
