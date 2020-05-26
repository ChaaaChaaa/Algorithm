package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Trie trie = new Trie();

        while (n --> 0){
            trie.insert(bufferedReader.readLine());
        }
        int ans = 0;
        while (m --> 0){
            if(trie.search(bufferedReader.readLine())){
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}

class Trie {
    private static class TrieNode {
        ArrayList<TrieNode> children;
        boolean endOfWord;

        TrieNode() {
            children = new ArrayList<>();
            endOfWord = false;
        }
    }

    private final TrieNode root;

    Trie() {
        root = new TrieNode();
    }

    void insert(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);
            if (node == null) {
                node = new TrieNode();
                current.children.add(node);
            }
            current = node;
        }
        current.endOfWord = true;
    }

    boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = currentNode.children.get(ch);
            if (node == null) {
                return false;
            }
            currentNode = node;
        }
        return currentNode.endOfWord;
    }

}