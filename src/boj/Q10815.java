package boj;


import java.util.Scanner;
import java.util.TreeSet;

public class Q10815 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        TreeSet<Integer> myArrayList = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int inputNumFirstLine = sc.nextInt();
            myArrayList.add(inputNumFirstLine);
        }

        int m = sc.nextInt();
        int[] cards = new int[m];


        for (int i = 0; i < m; i++) {
            cards[i]=sc.nextInt();
        }

        NumberCard numberCard = new NumberCard(myArrayList,cards);
        numberCard.binarySearch();
        System.out.println(numberCard.sb);

    }
}

class NumberCard {
    private static final int EXIST = 1;
    private static final int NOT_EXIST = 0;
    private static final char BLANK = ' ';

    int[] cards;
    TreeSet<Integer> myArrayList ;
    StringBuilder sb = new StringBuilder();

    NumberCard(TreeSet<Integer> myArrayList, int[] cards) {
        this.myArrayList = myArrayList;
        this.cards = cards;
    }

    public void binarySearch() {
        for(int card : cards){
            if(myArrayList.contains(card)){
                sb.append(EXIST).append(BLANK);
            }
            else {
                sb.append(NOT_EXIST).append(BLANK);
            }
        }
    }
}
