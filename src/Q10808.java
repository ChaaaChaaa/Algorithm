import java.util.Scanner;

public class Q10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        NumberOfAlphabet numberOfAlphabet = new NumberOfAlphabet(word);

        numberOfAlphabet.inputStringToArr();
        numberOfAlphabet.countOfAlphabet();
        numberOfAlphabet.printArr();
    }
}

class NumberOfAlphabet {
    private static final int NumOfSmallLetter = 26;
    private static final int ASCII_smallLetterA = 97;
    private static final String SPACE = " ";

    private char[] alphabetArr;
    private int[] countOfAlphabetArr = new int[NumOfSmallLetter];
    private String word;
    private int size;

    NumberOfAlphabet(String word) {
        this.word = word;
        size = word.length();
        alphabetArr = new char[size];
    }

    void inputStringToArr() {
        for (int i = 0; i < size; i++) {
            alphabetArr[i] = word.charAt(i);
        }
    }

    void countOfAlphabet() {
        char temp = ASCII_smallLetterA;

        for (int i = 0; i < NumOfSmallLetter ; i++, temp++) {

            for (int j = 0; j < size; j++) {
                if (temp == alphabetArr[j]) {
                    countOfAlphabetArr[i] += 1;
                }
            }
        }
    }

    void printArr() {
        for (int element : countOfAlphabetArr) {
            System.out.print(element + SPACE);
        }
    }
}


