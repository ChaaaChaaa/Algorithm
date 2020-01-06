import java.util.*;

// 퀵소트 정렬 필요 나중에 풀기

public class Q1882 {
    public static void main(String[] args){
        Irreducible irreducible = new Irreducible();
        Scanner sc = new Scanner(System.in);

     // List<Object> arr = new ArrayList<Object>();

        int cnt =0;

        int num = sc.nextInt();
        int index = sc.nextInt();

        int size = num*6;
        String arr[] = new String[size];
        for(int i=1; i<=num; i++){
            for(int j=2; j<=num; j++){
                if(i<j &&irreducible.gcd(i,j) == 1){
                   //arr.add(cnt,i+" "+j);
                   // System.out.println(i+","+j);
                    arr[cnt] = i+" "+j;
                    cnt++;
                }
            }

        }
        System.out.println(arr[index-1]);
      // System.out.println(arr.get(index+1));


    }
}




class Irreducible {
    public int gcd(int a, int b) {
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        while (true) {
            int r = a % b;

            if (r == 0) {
                return b;

            } else {
                a = b;
                b = r;
            }
        }
    }
}


