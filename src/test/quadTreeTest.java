package test;

public class quadTreeTest {
    public static void main(String[] args){
        test test = new test();
        test.test2();
        int a = 1/2;
        System.out.println("11111111: "+a);

    }
}

class test{


    void test2(){
        if(test1()){
            System.out.println("test5");
        }
        else {
            System.out.println("test6");
        }
    }

    boolean test1 (){
        for(int i=1; i<10; i++){
            System.out.println("test1: "+i);
            for(int j=1; j<5; j++){
                System.out.println("test2: "+j);
                if(j%2 == 0){
                    System.out.println("test3: "+j);
                    return false;
                }
                System.out.println("test4: "+j);
            }
        }
        return true;
    }
}
