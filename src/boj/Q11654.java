package boj;

import java.util.Scanner;

public class Q11654 {
    public static void main(String[] args) {
        AsciiCode asciiCode = new AsciiCode();
        Scanner sc = new Scanner(System.in);
        char asc = sc.next().charAt(0);
        asciiCode.ascCal(asc);

    }
}

class AsciiCode {
    public void ascCal(char asc) {
        System.out.print((int) asc);
    }
}