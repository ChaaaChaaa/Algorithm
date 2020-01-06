import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q9020 {
    public static void main(String[] args){
        GoldNum goldNum = new GoldNum();
        ArrayList<Integer> rangeInPrimeList = new ArrayList<>();
        ArrayList<Integer> primeNumForAdd = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int countNum = sc.nextInt();

        for(int i=0; i<countNum; i++){
            int num = sc.nextInt();
            int[] primeList = new int[num+10];

            goldNum.resetPrimeList(primeList,num+10);
            goldNum.calEratosthenes(primeList,num+10);
            goldNum.insertRangePrimeNum(primeList,rangeInPrimeList,goldNum.makeStartNum(num),num+10);
            goldNum.find2PrimeNum(rangeInPrimeList,primeNumForAdd,num);
            goldNum.compare2PrimeNum(primeNumForAdd);


        }
    }
}

class GoldNum{
    int makeStartNum(int num){
        if(num < 0){
            num =0;
        }
        return num;
    }

    void resetPrimeList(int[] primeList, int end) {
        for (int i = 0; i < end; i++) {
            primeList[i] = 0;
            primeList[1] = 1;
        }
    }

    void calEratosthenes(int[] primeList, int end) {
        for (int i = 2; i < end; i++) {
            for (int j = 2; j * i < end; j++) {
                primeList[i * j] = 1;
            }
        }
    }

    void insertRangePrimeNum(int[] primeList,ArrayList<Integer> rangeInPrimeList, int start, int end) {
        for (int i = start; i < end; i++) {
            if (primeList[i] != 1) {
                rangeInPrimeList.add(i);
                Collections.sort(rangeInPrimeList);
            }
        }

    }

    void find2PrimeNum(ArrayList<Integer> rangeInPrimeList,ArrayList<Integer> primeNumForAdd,int num){
        for (int i=0; i<rangeInPrimeList.size(); i++){
            for (int j=0; j<rangeInPrimeList.size(); j++){
                if(num == i+j){
                    primeNumForAdd.add(i);
                    primeNumForAdd.add(j);
                }
            }
        }
    }

    void compare2PrimeNum(ArrayList<Integer> primeNumForAdd){
        for(int i =0; i<primeNumForAdd.size()-1; i++){
            for(int j=0; j<primeNumForAdd.size(); j++){
                if(primeNumForAdd.get(j)-primeNumForAdd.get(i) > primeNumForAdd.get(j+2)-primeNumForAdd.get(i+2)){
                    System.out.println(i+" "+j);
                }
                else{
                    System.out.println(i+2+" "+j+2);
                }


            }
        }
    }

}
