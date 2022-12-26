package boj;

import java.util.Scanner;

public class Q1107 {
    private static final int numOfButtons = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wantedChannel = sc.nextInt();
        int numOfBrokenButtons = sc.nextInt();

        boolean[] buttons = new boolean[numOfButtons];

        for (int i = 0; i < numOfBrokenButtons; i++) {
            int brokenButton = sc.nextInt();
            buttons[brokenButton] = true;
        }

        RemoteControl remoteControl = new RemoteControl(wantedChannel, buttons);
        remoteControl.countHowManyPush_PlusAndMinusButtons();
        remoteControl.countHowManyPush_NumButtons();

    }
}

class RemoteControl {
    private static final int limitChannels = 1000000;
    private static final int presentChannel = 100;
    private static final int findNDigits = 10;
    private static final int brokenButton = 0;
    private static final int unBrokenButton = 1;


    private int wantedChannel;
    private boolean[] buttons;
    private int answer;
    private int countPushChannel ;

    RemoteControl(int wantedChannel, boolean[] buttons) {
        this.wantedChannel = wantedChannel;
        this.buttons = buttons;

    }


    void countHowManyPush_PlusAndMinusButtons() {
        answer = Math.abs(wantedChannel - presentChannel);
    }

    void countHowManyPush_NumButtons() {
        for (int i = 0; i <= limitChannels; i++) {
            int bruteForceChannel = i;

            countPushChannel = countPushButton_ToMoveChannel(bruteForceChannel);

            if (countPushChannel > 0) {
                int currentChannel = bruteForceChannel - wantedChannel;

                if (currentChannel < 0) {
                    currentChannel = -currentChannel;
                }

                if (answer > countPushChannel + currentChannel) {
                    answer = countPushChannel + currentChannel;
                }
            }
        }
        System.out.println(answer);
    }

    private int countPushButton_ToMoveChannel(int bruteForceChannel) {
        countPushChannel = 0;
        if (bruteForceChannel == 0) {
            if (buttons[0]) {
                return brokenButton;
            }
            return unBrokenButton;
        }

        while (bruteForceChannel > 0) {
            int checkEachDigitChannel = bruteForceChannel % findNDigits;

            if (buttons[checkEachDigitChannel]) {
                return brokenButton;
            }
            countPushChannel++;
            bruteForceChannel /= findNDigits;
        }
        return countPushChannel;
    }

}