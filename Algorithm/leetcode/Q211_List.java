package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Q211_List {
    public static void main(String[] args) {
        root.addWord("bad");
        System.out.println( search("bad"));
    }

    static class TrieNode {
        char val;
        boolean isEnd;
        List<TrieNode> children;
        TrieNode(char c) {
            val = c;
            isEnd = false;
            children = new ArrayList();
        }
        void addWord(String word) {
            for(TrieNode node:children) {
                if(node.val == word.charAt(0)) {
                    if(word.length() == 1) {
                        node.isEnd = true;
                        return;
                    }
                    else {
                        node.addWord(word.substring(1));
                        return;
                    }
                }
            }
            TrieNode ch = new TrieNode(word.charAt(0));
            children.add(ch);
            if(word.length() == 1) {
                ch.isEnd = true;
                return;
            }
            ch.addWord(word.substring(1));
        }
        boolean search(String word) {
            for(TrieNode node:children) {
                if(node.val == word.charAt(0) || word.charAt(0) == '.') {
                    if(word.length() == 1)
                        return node.isEnd;
                    if(node.search(word.substring(1)))
                        return true;
                }
            }
            return false;
        }
    }

    static TrieNode root;
    public Q211_List() {
        root = new TrieNode(' ');
    }

    public static void addWord(String word) {
        root.addWord(word);
    }

    public static boolean search(String word) {
        return root.search(word);
    }
}
