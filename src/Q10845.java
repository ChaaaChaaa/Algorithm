import java.io.*;
import java.util.StringTokenizer;


public class Q10845 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String command;

        int testCases = Integer.parseInt(br.readLine());
        Queue2 queue2 = new Queue2(testCases);

        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            command = st.nextToken();

            if (command.equals("push")) {
                int inputNum = Integer.parseInt(st.nextToken());
                queue2.enQueue(inputNum);
            }

            if (command.equals("pop")) {
               // System.out.println(queue2.deQueue());
                bw.write(queue2.deQueue()+""+"\n");
            }

            if (command.equals("size")) {
               // System.out.println(queue2.printQueueNumber());
                bw.write(queue2.printQueueNumber()+""+"\n");
            }

            if (command.equals("empty")) {
                //System.out.println(queue2.empty());
                bw.write(queue2.empty()+""+"\n");
            }

            if (command.equals("front")) {
               // System.out.println(queue2.front());
                bw.write(queue2.front()+""+"\n");
            }

            if (command.equals("back")) {
               // System.out.println(queue2.back());
                bw.write(queue2.back()+""+"\n");
            }
           bw.flush();
        }



    }
}

class Queue2 {

    private int front;
    private int rear;
    private int queueSize;
    private int[] numberArray;
    private int countNumberInQueue = 0;


    Queue2(int queueSize) {
        this.queueSize = queueSize;
        front = rear = 0;
        numberArray = new int[queueSize];
    }

    private boolean isEmpty() {
        return (front == rear);
    }

    private boolean isFull() {
        return (((rear + 1) % this.queueSize) == front);
    }


    void enQueue(int inputNum) {
        if (isFull()) {
            System.out.println("-1");

        } else {
            rear = (rear + 1) % this.queueSize;
            numberArray[rear] = inputNum;
            countNumberInQueue++;
        }

    }

    int deQueue() {
        if (isEmpty()) {
            return -1;
        } else {
            front = (front + 1) % this.queueSize;
            countNumberInQueue--;
            return numberArray[front];
        }

    }

    int printQueueNumber() {
        if (isEmpty()) {
            return 0;
        }
        return countNumberInQueue;
    }

    int empty() {
        if (isEmpty()) {
            return 1;
        }
        return 0;
    }

    int front() {
        if (isEmpty()) {
            return -1;
        } else
            return numberArray[(front + 1) % queueSize];
    }

    int back() {
        if (!isEmpty()) {
            return numberArray[(rear) % queueSize];
        }
        return -1;
    }

}
