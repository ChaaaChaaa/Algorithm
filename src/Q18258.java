import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Q18258 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCases = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Queue3 queue3 = new Queue3();

        for (int i = 0; i < testCases; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.contains("push")) {
                int inputNum = Integer.parseInt(st.nextToken());
                queue3.enQueue(inputNum);
            }

            if (command.contains("pop")) {
                sb.append(queue3.deQueue()).append("\n");
            }

            if (command.contains("size")) {
                sb.append(queue3.size()).append("\n");
            }

            if (command.contains("empty")) {
                sb.append(queue3.empty()).append("\n");
            }

            if (command.contains("front")) {
                sb.append(queue3.front()).append("\n");
            }

            if (command.contains("back")) {
                sb.append(queue3.back()).append("\n");
            }

        }
        System.out.println(sb);
    }
}

class QNode {
    int data;
    QNode next;

    QNode(int inputData) {
        this.data = inputData;
        this.next = null;
    }
}


class Queue3 {
    private static final int noNumInQueue = -1;
    private static final int emptyInQueue = 1;
    private static final int notEmptyInQueue = 0;

    private QNode front;
    private QNode rear;
    private int queueSize = 0;

    Queue3() {
        this.front = null;
        this.rear = null;
    }

    private boolean isEmpty() {
        return (front == null);
    }

    void enQueue(int inputNum) {
        QNode newNode = new QNode(inputNum);
        queueSize++;

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int deQueue() {
        if (isEmpty()) {
            return noNumInQueue;
        }

        queueSize--;
        int deleteData = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return deleteData;
    }

    int back() {
        if (isEmpty()) {
            return noNumInQueue;
        }
        return rear.data;
    }

    int front() {
        if (isEmpty()) {
            return noNumInQueue;
        }
        return front.data;
    }

    public int size() {
        if (isEmpty()) {
            return notEmptyInQueue;
        }
        return queueSize;
    }

    int empty() {
        if (isEmpty()) {
            return emptyInQueue;
        }
        return notEmptyInQueue;
    }

}
