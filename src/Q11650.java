import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q11650 {
    private static final  String SPACE = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;

        int countLocation = Integer.parseInt(br.readLine());
        SortLocation[] sortLocations = new SortLocation[countLocation];

        for (int i = 0; i < countLocation; i++) {
            tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            sortLocations[i] = new SortLocation(x, y);
        }

        Arrays.sort(sortLocations);

        for (SortLocation sortLocation : sortLocations) {
            System.out.println(sortLocation.getX() +SPACE+ sortLocation.getY());
        }

    }
}

class SortLocation implements Comparable<SortLocation> {
    private int x;
    private int y;

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }


    SortLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(SortLocation o) {
        if (this.x < o.x) {
            return -1;
        } else if (this.x == o.x) {
            if (this.y < o.y) {
                return -1;
            } else if (this.y == o.y) {
                return 0;
            } else {
                return 1;
            }
        }
        return 1;
    }
}
