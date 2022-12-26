package boj;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
    private static final int numOfDwarfs = 9;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] heightOfDwarfs = new int[numOfDwarfs];

        for (int i = 0; i < numOfDwarfs; i++) {
            heightOfDwarfs[i] = sc.nextInt();
        }

        SevenDwarfs sevenDwarfs = new SevenDwarfs(heightOfDwarfs);
        sevenDwarfs.sumOfHeights();
        sevenDwarfs.sortHeights();
        sevenDwarfs.findTwo_WhoAreNotWhiteDwarfs();
        sevenDwarfs.printWhiteDwarfs();
    }
}

class SevenDwarfs {
    private static final int numOfDwarfs = 9;
    private static final int sumOfWhiteDwarfsHeight = 100;
    private int[] heightOfDwarfs;
    private int sumOfHeight = 0;
    private boolean check = false;

    SevenDwarfs(int[] heightOfDwarfs) {
        this.heightOfDwarfs = heightOfDwarfs;
    }

    void sumOfHeights() {
        for (int i = 0; i < numOfDwarfs; i++) {
            sumOfHeight += heightOfDwarfs[i];
        }
    }

    void sortHeights() {
        Arrays.sort(heightOfDwarfs);
    }

    void findTwo_WhoAreNotWhiteDwarfs() {
        for (int i = 0; i < numOfDwarfs; i++) {

            if(check){
                break;
            }

            for (int j = i + 1; j < numOfDwarfs; j++) {
                if(i == j){
                    continue;
                }

                if (flagSubtractHeights_CantMakeSum(i, j)) {
                    heightOfDwarfs[i] = 0;
                    heightOfDwarfs[j] = 0;
                    check = true;
                    break;
                }

            }

        }
    }

    private boolean flagSubtractHeights_CantMakeSum(int i, int j) {
        int heightDiff = sumOfHeight - sumOfWhiteDwarfsHeight;
        return (heightOfDwarfs[i] + heightOfDwarfs[j]) == heightDiff;
    }

    void printWhiteDwarfs() {
        for (int value : heightOfDwarfs) {
            if (value != 0) {
                System.out.println(value);
            }
        }
    }
}
