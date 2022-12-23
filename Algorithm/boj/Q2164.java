package boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> cardQueue = new LinkedList<>();

        int countCardNum = sc.nextInt();
        for (int i = 1; i <= countCardNum; i++) {
            cardQueue.add(i);
        }

        Card2 card2 = new Card2(cardQueue);
        card2.cardDeleteAndMix();
        System.out.println(card2.printLastOneCardNum());

    }
}

class Card2 {
    private Queue<Integer> cardQueue;

    Card2(Queue<Integer> cardQueue) {
        this.cardQueue = cardQueue;
    }

    void cardDeleteAndMix() {
        while (cardQueue.size() > 1) {
            cardQueue.poll();
            cardQueue.add(cardQueue.poll());
        }
    }

    int printLastOneCardNum() {
        if (cardQueue.size() == 1) {
            return cardQueue.poll();
        }
        return 0;
    }
}
