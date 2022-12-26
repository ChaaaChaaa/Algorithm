package sort;

import java.io.*;
import java.util.StringTokenizer;

public class Q3047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] inputNumArr = new int[3];

        for (int i = 0; i < inputNumArr.length; i++) {
            inputNumArr[i] = Integer.parseInt(st.nextToken());
        }

        ABC abc = new ABC(inputNumArr);
        abc.insertSort();

        String[] inputAlphabet = br.readLine().split("");

        for (int i = 0; i < 3; i++) {
            System.out.print(abc.printToMatchABC(i, inputAlphabet));
        }

    }
}

class ABC {
    private static final String SPACE = " ";
    private int[] inputNumArr;
    private int j, temp;
    private int size;


    ABC(int[] inputNumArr) {
        this.inputNumArr = inputNumArr;
        size = inputNumArr.length;
    }

    void insertSort() {
            for (int i = 1; i < size; i++) {
                temp = inputNumArr[i];
                j = i;
                swapInsertionSort();
                inputNumArr[j] = temp;
            }
    }

    private void swapInsertionSort() {
        while (biggerThanZeroOrTemp()) {
            inputNumArr[j] = inputNumArr[j - 1];
            j--;
        }
    }

    private boolean biggerThanZeroOrTemp() {
        return j > 0 && temp < inputNumArr[j - 1];
    }

    private int convertWordToNum(int i, String[] inputAlphabet) {
        return inputAlphabet[i].charAt(0) - 'A';
    }

    String printToMatchABC(int i, String[] inputAlphabet) {
        return inputNumArr[convertWordToNum(i, inputAlphabet)] + SPACE;
    }

}
