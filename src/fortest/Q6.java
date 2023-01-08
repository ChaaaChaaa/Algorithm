package fortest;

import java.util.*;
class Main{
    static int [] uf;
    public static int find(int v){
        if(v == uf[v]){ return v;}
        else{ return uf[v] = find(uf[v]); }
    }
    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa != fb){ uf[fa] = fb; }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        uf = new int[n+1];
        for(int i=1; i<=n; i++){
            uf[i] = i;
        }
        for(int i=1; i<=m; i++){
            int a =sc.nextInt();
            int b = sc.nextInt();
            union(a,b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(find(a) != find(b)){
            System.out.println("NO");
        }else{
            System.out.println("Yes");
        }
    }
}
