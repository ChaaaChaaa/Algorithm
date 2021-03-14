package leetcode;

public class Q211 {
    public static void main(String[] args) {
        addWord("bad");
        System.out.println(search("bad"));
    }

    public static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord;
    }

    private static TrieNode root = new TrieNode();

    // Adds a word into the data structure.
    public static void addWord(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode();
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public static boolean search(String word) {
        return match(word.toCharArray(), 0, root);
    }

    private static boolean match(char[] chs, int k, TrieNode node) {
        if (k == chs.length) {
            return node.isWord;
        }
        if (chs[k] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && match(chs, k + 1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[chs[k] - 'a'] != null && match(chs, k + 1, node.children[chs[k] - 'a']);
        }
        return false;
    }
}