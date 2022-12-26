package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Q1475 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputRoomNum = br.readLine();
        RoomNumber roomNumber = new RoomNumber(inputRoomNum);
        roomNumber.splitRoomNumber();
        roomNumber.sortArr();
        roomNumber.printTheMostCardElement();

    }
}

class RoomNumber {
    private static final int EXCEPTION_NUM_6 = 6;
    private static final int EXCEPTION_NUM_9 = 9;
    private static final int zeroToChangeASCII = 48;

    private int[] roomNumArr;
    private int[] countCardElement = new int[10];
    private String inputRoomNum;
    private int size;
    private boolean flag = true;


    RoomNumber(String inputRoomNum) {
        this.inputRoomNum = inputRoomNum;
        size = inputRoomNum.length();
        roomNumArr = new int[size];
    }

    void splitRoomNumber() {
        for (int i = 0; i < size; i++) {
            roomNumArr[i] = inputRoomNum.charAt(i) - zeroToChangeASCII;
            compareRoomNumAndCardSet(i);
        }
    }

    private void compareRoomNumAndCardSet(int i) {

        if (check(i)) {
            exceptionAbout6And9();
        }

        if (!check(i)) {
            countCardElement[roomNumArr[i]] += 1;
        }

    }

    private void exceptionAbout6And9() {
        if (flag) {
            countCardElement[EXCEPTION_NUM_6] += 1;
            flag = false;
        } else {
            flag = true;
        }
    }

    private boolean check(int i) {
        return (roomNumArr[i] == EXCEPTION_NUM_6 || roomNumArr[i] == EXCEPTION_NUM_9);
    }

    void sortArr() {
        Arrays.sort(countCardElement);
    }

    void printTheMostCardElement() {
        int result = countCardElement[9];
        System.out.println(result);
    }
}
