package inflearn;

import java.util.ArrayList;
import java.util.Scanner;

public class Q68 {
    //피자
    static int n,m,length, ans = Integer.MAX_VALUE;
    static int [] combination;
    static ArrayList<Point> house,pizzaShop;

    public void DFS(int level, int s){
        if(level==m){
            int sum = 0;
            for(Point current : house){
                int distance = Integer.MAX_VALUE;
                for(int i:combination){
                    distance = Math.min(distance,Math.abs(current.x-pizzaShop.get(i).x)+Math.abs(current.y-pizzaShop.get(i).y)); //왜?
                }
                sum += distance;
            }
            ans = Math.min(ans,sum);
        }

        else{
            for(int i=s; i<length; i++){
                combination[level] = i;
                DFS(level+1,i+1);
            }
        }
    }

    public static void main(String[] args){
        Q68 q68 = new Q68();
        Scanner sc = new Scanner(System.in);
        n= sc.nextInt();
        m=sc.nextInt();

        pizzaShop = new ArrayList<>();
        house = new ArrayList<>();

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int currentPosition = sc.nextInt();
                if(currentPosition == 1){
                    house.add(new Point(i,j));
                }
                else if(currentPosition == 2){
                    pizzaShop.add(new Point(i,j));
                }
            }
        }

        length = pizzaShop.size();
        combination = new int[m];
        q68.DFS(0,0);
        System.out.println(ans);
    }
}
