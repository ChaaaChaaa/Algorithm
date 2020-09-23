package programmers;

import test.ConvertWord2;

import java.util.LinkedList;
import java.util.Queue;

public class ConvertWord {
    class Node {
        String word;
        int edge;

        public Node(String word, int edge) {
            this.word = word;
            this.edge = edge;
        }
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[words.length];
        queue.add(new Node(begin, 0));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.word.equals(target)) {
                System.out.println("가  currentNode.edge : "+currentNode.edge );
                answer = currentNode.edge;
                break;
            }
            System.out.println("0");
            for (int i = 0; i < words.length; i++) {

                System.out.println("나 isNext(currentNode.word, words[i]) : "+isNext(currentNode.word, words[i])
                +" currentNode.word :"+currentNode.word+" i : "+i +" currentNode.edge : "+currentNode.edge
                +"visited[i] : "+visited[i]);

                if (!visited[i] && isNext(currentNode.word, words[i])) {
                    visited[i] = true;
                    System.out.println("다 i :"+i+" words[i] :"+words[i]+" currentNode.edge + 1 : "+(currentNode.edge + 1));
                    queue.add(new Node(words[i], currentNode.edge + 1));
                }
                System.out.println("나 끝");
            }
        }
        return answer;
    }

    boolean isNext(String currentWord, String next) {
        int count = 0;
        System.out.println("1");
        for (int i = 0; i < currentWord.length(); i++) {
            System.out.println("라 count :"+count+" i :"+i+" currentWord.charAt(i) : "+currentWord.charAt(i)
                    +" currentWord: "+currentWord+" next: "+next+" next.charAt(i): "+next.charAt(i));

            if (currentWord.charAt(i) != next.charAt(i)) {
                System.out.println("마 count :"+count+" i :"+i+" currentWord.charAt(i) : "+currentWord.charAt(i)
                        +" currentWord: "+currentWord+" next: "+next+" next.charAt(i): "+next.charAt(i));

                count++;
            }
            System.out.println("2");
            if (count > 1) {
                System.out.println("바 count :"+count+" i :"+i+" currentWord.charAt(i) : "+currentWord.charAt(i)
                        +" currentWord: "+currentWord+" next: "+next);
                return false;
            }
            System.out.println("3");
        }
        return true;
    }

    public static void main(String[] args) {
        ConvertWord convertWord = new ConvertWord();

        String[] words = {"hot", "dot", "dog", "lot","cog"};

        int result = convertWord.solution("hit", "cog", words);
        System.out.println(result);
    }
}
