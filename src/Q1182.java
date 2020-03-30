import java.util.Scanner;

public class Q1182 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();

        int [] sequenceArr = new int[N];

        for(int i=0; i<N; i++){
            sequenceArr[i] = sc.nextInt();
        }


        SumOfPartialSequence sumOfPartialSequence = new SumOfPartialSequence(N,S,sequenceArr);
        sumOfPartialSequence.bitMask();

    }
}

class SumOfPartialSequence{
    private static final int startNValue = 1;

    private static final int initBitMask = 1;
    private static final int notIncludeElement = 0;

    private static final int initValue = 0;
    private static final int increasedValue = 1;



    private int N;
    private int S;
    private int [] sequenceArr;

    SumOfPartialSequence(int N, int S,  int [] sequenceArr){
        this.N = N;
        this.S = S;
        this.sequenceArr = sequenceArr;
    }

    private int ans = 0;

    void bitMask(){

        for(int i =startNValue; i<(initBitMask<<N); i++){
            int sum = initValue;
            for(int k=initValue; k<N; k++){
                if((i & (initBitMask<<k)) != notIncludeElement ){
                    sum += sequenceArr[k];
                }
            }

            if(sum == S){
                ans += increasedValue;
            }
        }
        System.out.println(ans);
    }
}
