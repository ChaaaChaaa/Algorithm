package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q1546 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        Arrays.sort(arr);


        double sum = 100;

        for (int i = 0; i < arr.length - 1; i++) {
            sum += (arr[i] / arr[arr.length - 1]) * 100;
            System.out.println(arr[i] / arr[arr.length - 1]);
        }

        double avg = sum / n;
        System.out.println(avg);
    }
}
