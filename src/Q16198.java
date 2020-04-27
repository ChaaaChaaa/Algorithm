
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q16198 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> inputArrayList = new ArrayList<>();
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inputArrayList.add(Integer.parseInt(st1.nextToken()));
        }

        GettingEnergy gettingEnergy = new GettingEnergy();
       int a =  gettingEnergy.recursion(inputArrayList);
        System.out.println(a);
    }
}

class GettingEnergy {

    int recursion(ArrayList<Integer> inputArrayList) {
        int size = inputArrayList.size();

        if (size == 2) {
            return 0;
        }

        int answer = Integer.MIN_VALUE;

        for (int i = 1; i < size - 1; i++) {
            int energy = inputArrayList.get(i - 1) * inputArrayList.get(i + 1);
            ArrayList<Integer> newArrayList = new ArrayList<>(inputArrayList);

            newArrayList.remove(i);
            energy += recursion(newArrayList);

            if (answer < energy) {
                answer = energy;
            }
        }
        return answer;
    }
}
