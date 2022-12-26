package boj;

import java.util.Scanner;

public class Q2775 {

    public static void main(String[] args) {
        PeopleLiveInAPT peopleLiveInAPT = new PeopleLiveInAPT();
        int[][] checkApartment = peopleLiveInAPT.findFloor();
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            int floor = sc.nextInt();
            int roomNumber = sc.nextInt();
            System.out.println(checkApartment[floor][roomNumber - 1]);
        }

    }
}

class PeopleLiveInAPT {
    private static final int MAX_SIZE = 15;
    int[][] findFloor() {
        int[][] apartment = new int[MAX_SIZE][MAX_SIZE];
        for (int i = 0; i < MAX_SIZE; i++) {
            apartment[0][i] = i + 1;
            apartment[i][0] = 1;
        }

        for (int i = 1; i < MAX_SIZE; i++) {
            for (int j = 1; j < MAX_SIZE; j++) {
                apartment[i][j] = apartment[i - 1][j] + apartment[i][j - 1];
            }

        }
        return apartment;
    }
}
