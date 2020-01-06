import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Q10814 {
    private static final  String SPACE = " ";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer;

        int inputCustomerInfo = Integer.parseInt(br.readLine());
        SortAges[] sortAge = new SortAges[inputCustomerInfo];

        for (int i = 0; i < inputCustomerInfo; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(stringTokenizer.nextToken());
            String name = stringTokenizer.nextToken();
            sortAge[i] = new SortAges(age, name, i);
        }

        Arrays.sort(sortAge);

        for (SortAges sortAges : sortAge) {
            System.out.println(sortAges.getAge() +SPACE+ sortAges.getName());
        }

    }
}

class SortAges implements Comparable<SortAges> {
    private int age;
    private int joinedYear;
    private String name;

    SortAges(int age, String name, int joinedYear) {
        this.age = age;
        this.joinedYear = joinedYear;
        this.name = name;
    }

    @Override
    public int compareTo(SortAges o) {
        if (this.age < o.age) {
            return -1;
        }
        if (this.age == o.age) {
            if (this.joinedYear < o.joinedYear) {
                return -1;
            }
            if (this.joinedYear == o.joinedYear) {
                return 0;
            } else {
                return 1;
            }
        } else {
            return 1;
        }
    }

    int getAge() {

        return age;
    }

    String getName() {

        return name;
    }
}
