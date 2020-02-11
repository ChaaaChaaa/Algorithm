import java.util.Scanner;

public class Q10808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        NumberOfAlphabet numberOfAlphabet = new NumberOfAlphabet(word);


        numberOfAlphabet.countOfAlphabet();
        numberOfAlphabet.printArr();
    }
}

class NumberOfAlphabet {
    private static final int NumOfSmallLetter = 26;
    private static final char convertStringToInt = 'a';
    private static final String SPACE = " ";

    private int[] countOfAlphabetArr = new int[NumOfSmallLetter];
    private String word;
    private int size;

    NumberOfAlphabet(String word) {
        this.word = word;
        size = word.length();
    }


    void countOfAlphabet() {
      for(int i=0; i<size; i++){
          countOfAlphabetArr[word.charAt(i)-convertStringToInt]++;
      }
    }

    void printArr() {
        for (int element : countOfAlphabetArr) {
            System.out.print(element + SPACE);
        }
    }
}
