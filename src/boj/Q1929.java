package boj;

import java.util.Scanner;

public class Q1929 {
    public static void main(String[] args) {
        Eratosthenes eratosthenes = new Eratosthenes();
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        int[] primeList = new int[end + 1];

        eratosthenes.resetPrimeList(primeList, end);
        eratosthenes.calEratosthenes(primeList, end);
        eratosthenes.printPrimeNum(primeList, start, end);

    }
}

class Eratosthenes {

    void resetPrimeList(int[] primeList, int end) {
        for (int i = 0; i <= end; i++) {
            primeList[i] = 0;
            primeList[1] = 1;
        }
    }

    void calEratosthenes(int[] primeList, int end) {
        for (int i = 2; i <= end; i++) {
            for (int j = 2; j * i <= end; j++) {
                primeList[i * j] = 1;
            }
        }
    }

    void printPrimeNum(int[] primeList, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (primeList[i] != 1) {
                System.out.println(i);
            }
        }

    }

}
