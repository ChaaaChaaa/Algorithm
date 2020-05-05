package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11651 {
    private static final String SPACE = " ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int inputLocation = Integer.parseInt(br.readLine());
        SortLocationYtoX[] sortLocationYtoX = new SortLocationYtoX[inputLocation];

        for (int i = 0; i < inputLocation; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            sortLocationYtoX[i] = new SortLocationYtoX(x, y);
        }

        Arrays.sort(sortLocationYtoX);

        for (SortLocationYtoX sortLocationYtoXES : sortLocationYtoX) {
            System.out.println(sortLocationYtoXES.getX() + SPACE + sortLocationYtoXES.getY());
        }

    }
}

class SortLocationYtoX implements Comparable<SortLocationYtoX> {
    private int x;
    private int y;

    SortLocationYtoX(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(SortLocationYtoX o) {
        if (this.y > o.y) {
            return 1;
        }

        if (this.y == o.y) {
            if (this.x > o.x) {
                return 1;
            }
            if (this.x == o.x) {
                return 0;
            } else {
                return -1;
            }
        }
        return -1;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}
