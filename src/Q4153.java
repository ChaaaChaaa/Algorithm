import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q4153 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        Pythagorean pythagorean = new Pythagorean();
        Scanner sc = new Scanner(System.in);

        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
           // System.exit(-1);
            boolean isSucceed = pythagorean.calPythagorean(a, b, c);
            if (!isSucceed) {
                break;
            }
        }
    }
}

class Pythagorean {
    void sortPythagorean(ArrayList<Integer> list) {
        Collections.sort(list);
        //소스코드를 보면 Collections.sort() 메소드는Arrays.sort()를 사용
        //return list;
    }

    boolean calPythagorean(int a, int b, int c) {

        if (a == 0 && b == 0 && c == 0) {
            return false;
        }
        if (isPythagorean(a, b, c)) {
            System.out.println("right");
            return true;
        }

        System.out.println("wrong");
        return true;
    }

    int getLongLength(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    boolean isPythagorean(int a, int b, int c) {
        int longLength = getLongLength(a, b, c);
        if (longLength == a) {

        }

        return Math.multiplyExact(a, a) == (Math.multiplyExact(b, b) + Math.multiplyExact(c, c));
    }
}
