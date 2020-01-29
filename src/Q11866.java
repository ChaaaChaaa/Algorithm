import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> josephusQueue = new LinkedList<>();

        for(int i=1; i<=n; i++){
            josephusQueue.add(i);
        }

        JosephusProblem josephusProblem = new JosephusProblem(josephusQueue,k);
        josephusProblem.findJosephusProblem();
        System.out.println(josephusProblem.printJosephusQueue());

    }
}

class JosephusProblem{
    private Queue josephusQueue;
    private int k;
    private StringBuilder sb = new StringBuilder();

    JosephusProblem(Queue josephusQueue, int k){
        this.josephusQueue = josephusQueue;
        this.k = k;
    }

    private void makeLinearArrangement(){
        for(int i=1; i<k; i++){
            josephusQueue.add(josephusQueue.poll());
        }
    }

    void findJosephusProblem(){
        sb.append("<");

        while (josephusQueue.size()>1){
            makeLinearArrangement();
            sb.append(josephusQueue.poll()).append(", ");
        }
        sb.append(josephusQueue.poll()).append(">");
    }

    String printJosephusQueue(){
        return sb.toString();
    }
}
