import java.io.*;
import java.util.StringTokenizer;

public class Q2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer(br.readLine());
        StringTokenizer st = new StringTokenizer(sb.reverse().toString());



        int intA = Integer.parseInt(st.nextToken());
        int intB = Integer.parseInt(st.nextToken());

        bw.write(String.valueOf(Math.max(intA, intB)));
        bw.flush();

    }
}


