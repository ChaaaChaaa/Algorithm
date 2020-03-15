import java.util.Arrays;
import java.util.Scanner;

public class Q1759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int C = sc.nextInt();

        char[] passwordElement = new char[C];

        for (int i = 0; i < C; i++) {
            passwordElement[i] = sc.next().charAt(0);
        }

        Arrays.sort(passwordElement);

        MakePassword makePassword = new MakePassword(L, C, passwordElement);
        makePassword.backtracking(0, 0, 0, 0, "");

    }
}

class MakePassword {
    private static final int increasingValue = 1;
    private static final int minimumNumOfVowel = 1;
    private static final int minimumNumOfConsonant = 2;
    private static final char vowel_A = 'a';
    private static final char vowel_E = 'e';
    private static final char vowel_I = 'i';
    private static final char vowel_O = 'o';
    private static final char vowel_U = 'u';


    private int L;
    private int C;
    private char[] passwordElement;

    MakePassword(int L, int C, char[] passwordElement) {
        this.L = L;
        this.C = C;
        this.passwordElement = passwordElement;
    }

    void backtracking(int index, int cnt, int vowel, int consonant, String passWord) {
        if (cnt == L) {
            if (vowel >= minimumNumOfVowel && consonant >= minimumNumOfConsonant) {
                System.out.println(passWord);
                return;
            }
        }

        if (index == C) {
            return;
        }

        if (flagHaveVowelOrNot(index)) {
            backtracking(index + increasingValue, cnt + increasingValue, vowel + increasingValue, consonant, passWord + passwordElement[index]);
        }

        if (!flagHaveVowelOrNot(index)) {
            backtracking(index + increasingValue, cnt + increasingValue, vowel, consonant + increasingValue, passWord + passwordElement[index]);
        }

        backtracking(index + increasingValue, cnt, vowel, consonant, passWord);
    }


    private boolean flagHaveVowelOrNot(int index) {
        return passwordElement[index] == vowel_A || passwordElement[index] == vowel_E || passwordElement[index] == vowel_I
                || passwordElement[index] == vowel_O || passwordElement[index] == vowel_U;
    }

}
