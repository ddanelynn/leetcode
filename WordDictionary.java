import java.util.*;

public class WordDictionary {
    Node root;
    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Node(word.charAt(i));
                curr.hasChildren = true;
            }
            curr = curr.children[index];
            if (i == word.length() - 1) {
                curr.length = i + 1;
            }
        }
    }
    
    public boolean search(String word) {
        return helper(0, word, root);
    }

    public static boolean helper(int index, String word, Node node) {
        if (node == null) {
            return false;
        }
        if (index == word.length()) {
            return node.length == word.length();
        }
        Node curr = node;
        if (word.charAt(index) == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && helper(index + 1, word, node.children[i])) {
                    return true;
                }
            }
        } else if (curr.children[word.charAt(index) - 'a'] != null) {
            return helper(index + 1, word, node.children[word.charAt(index) - 'a']);
        }
        return false; 
    }

    public static class Node {
        Node[] children;
        char c;
        int length;
        boolean hasChildren;
        public Node() {
            this.children = new Node[26]; 
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.hasChildren = false;
            this.length = -1;
        }
        public Node(char c) {
            this.c = c;
            this.children = new Node[26]; 
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
            this.hasChildren = false;
            this.length = -1;
        }
    }
}
