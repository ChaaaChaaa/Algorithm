package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13913 {
    public static final int MAX = 1000000;
    private static  void print(int[] from, int n, int m){
        if(n != m){
            print(from,n,from[m]);
        }
        System.out.print(m+" ");
    }


    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int [] dist = new int[MAX];
        int [] from = new int[MAX];
        boolean [] check = new boolean[MAX];

        check[n] = true;
        dist[n] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);

        while (!queue.isEmpty()){
            int move = queue.remove();

                if(move-1 >= 0){
                    if(check[move-1] == false ){
                    check[move-1] = true;
                    queue.add(move-1);
                    from[move-1] = move;
                    dist[move-1] = dist[move]+1;
                }
            }


                if(move+1 < MAX){
                    if(check[move+1] == false ){
                    check[move+1] = true;
                    queue.add(move+1);
                    from[move+1] = move;
                    dist[move+1] = dist[move]+1;
                }
            }


                if(move*2 < MAX){
                    if(check[move*2] == false ){
                    check[move*2] = true;
                    queue.add(move*2);
                    from[move*2] = move;
                    dist[move*2] = dist[move]+1;
                }
            }
        }
        System.out.println(dist[m]);
        print(from,n,m);
    }
}
