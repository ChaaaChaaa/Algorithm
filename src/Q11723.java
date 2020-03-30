import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q11723 {
    private static final int secondIndex = 1;
    private static final String space = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        Set set = new Set();

        for (int i = 0; i < tc; i++) {
            String[] command = br.readLine().split(space);

            if (command[0].equals("add")) {
                int num = Integer.parseInt(command[secondIndex])-1;
                set.addNum(num);
            }

            if (command[0].equals("remove")) {
                int num = Integer.parseInt(command[secondIndex])-1;
                set.removeNum(num);
            }

            if (command[0].equals("check")) {
                int num = Integer.parseInt(command[secondIndex])-1;
                set.checkNum(num);
            }

            if (command[0].equals("toggle")) {
                int num = Integer.parseInt(command[secondIndex])-1;
                set.toggleNum(num);
            }

            if (command[0].equals("all")) {
                set.allNum();
            }

            if (command[0].equals("empty")) {
                set.emptyNum();
            }

        }
        set.printStringBuilder();
    }


}

class Set {
    private static final int maxNum = 20;
    private static final int initAns = 0;

    private static final int initBitMask = 1;
    private static final int notIncludeElement = 0;

    private static final int changedOneSet = 1;
    private static final int nullSet = 0;


    private int ans = initAns;

    StringBuilder sb = new StringBuilder();


    void addNum(int num) {
        ans = ans | (initBitMask << num);
    }

    void removeNum(int num) {
        ans = ans & ~(1 << num);
    }

    void checkNum(int num) {
        if ((ans & (initBitMask << num)) != notIncludeElement) {
           sb.append("1").append("\n");
        }

        if ((ans & (initBitMask << num)) == notIncludeElement) {
            sb.append("0").append("\n");
        }
    }

    void toggleNum(int num) {
        ans = (ans ^ (initBitMask << num));
    }


    void allNum() {
        ans = (initBitMask << maxNum) - changedOneSet;
    }


    void emptyNum() {
        ans = nullSet;
    }

    void printStringBuilder(){
        System.out.println(sb);
    }

}
