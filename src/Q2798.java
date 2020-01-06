import java.util.Scanner;

public class Q2798 {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int cardCount = sc.nextInt();
        BlackJack blackJack = new BlackJack(cardCount);
        int cardSum = sc.nextInt();

        for(int i=0; i<cardCount; i++){
            int addCard = sc.nextInt();
            blackJack.appendCard(addCard);
        }

        blackJack.findLastCardNum(cardSum);

    }
}

class BlackJack{
    private int[] cardList;
    private int index = 0;


    BlackJack(int maxSize){
        cardList = new int[maxSize];
    }

    void appendCard(int addCard){
        cardList[index] = addCard;
        index++;
    }

    void findLastCardNum(int cardSum){
        int max =0;
        loop:
        for(int i=0; i<cardList.length-2; i++){
            for(int j=i+1; j<cardList.length-1; j++){
                for(int k =j+1; k<cardList.length; k++){

                    int sum = cardList[i]+cardList[j]+cardList[k];

                    if(sum<=cardSum){
                        max = Math.max(max,sum);
                    }
                    if(max == cardSum){
                        break loop;
                    }
                }
            }
        }
        System.out.print(max);
    }
}
