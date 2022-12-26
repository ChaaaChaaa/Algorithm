package inflearn;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person {
    int id;
    int priority;

    public Person(int id, int priority) {
        this.id = id;
        this.priority = priority;
    }
}

public class Q44 {
    public int q44(int n, int m, int[] arr) {
        int ans = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Person currentPerson = queue.poll();
            for (Person person : queue) {
                if (person.priority > currentPerson.priority) { //진료받으면 안되므로 뒤에다가 넣는다.
                    queue.offer(currentPerson);
                    currentPerson = null;
                    break;
                }
            }
            if (currentPerson != null) { //진료 받을수있음
              ans++;
              if(currentPerson.id == m){
                  return ans;
              }
            }
        }
        return ans;
    }

    public static void main(String[] args) throws IOException {
        Q44 q44 = new Q44();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(q44.q44(n, m, arr));
    }
}
