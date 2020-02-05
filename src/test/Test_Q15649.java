package test;

public class Test_Q15649 {
    public static void main (String[] args){
        dfc();
    }

    static void dfc(){
        for(int i=1; i<5; i++){
            System.out.println("test1 i: "+i);
            dfc();
            System.out.println("test2 i: "+i);
        }
    }
}
