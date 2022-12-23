package forstudy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5_8 {
    public int solution(int n, int m, int[] arr) {
        int ans = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }

        while (!queue.isEmpty()) {
            Person temp = queue.poll();
            for (Person person : queue) {
                if (person.priority > temp.priority) {
                    queue.offer(temp);
                    temp = null;
                    break;
                }
            }

            if (temp != null) {
                ans++;
                if (temp.id == m) {
                    return ans;
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Q5_8 q8 = new Q5_8();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(q8.solution(n, m, arr));
    }
}

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}


