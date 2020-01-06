import java.util.Scanner;

public class Q2675 {
    public static void main(String[] args) {
        RecursionWord recursionWord = new RecursionWord();
        Scanner sc = new Scanner(System.in);
        int countOrder = sc.nextInt();
        for (int i = 0; i < countOrder; i++) {
            int countNum1 = sc.nextInt();
            String inputWords1 = sc.next();
            recursionWord.recursionWord(inputWords1, countNum1);
            System.out.println();
        }
    }
}

class RecursionWord {
    char word;

    public void recursionWord(String inputWords, int countNum) {
        for (int i = 0; i < inputWords.length(); i++) {
            word = inputWords.charAt(i);
            for (int j = 0; j < countNum; j++) {
                System.out.print(word);
            }

        }
    }
}

