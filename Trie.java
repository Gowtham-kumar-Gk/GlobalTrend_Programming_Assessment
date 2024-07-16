package Test;

class Trie {

    // TrieNode class represents each node in the Trie
    class TrieNode {
        // Array to store references to child nodes
        TrieNode[] children = new TrieNode[26];
        // Boolean flag to indicate if the node is the end of a word
        boolean isEndOfWord = false;
    }

    // Root node of the Trie
    private TrieNode root;

    // Constructor to initialize the root node
    public Trie() {
        root = new TrieNode();
    }

    // Method to insert a word into the Trie
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }

    // Method to search for a word in the Trie
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return node.isEndOfWord;
    }

    // Method to check if any word in the Trie starts with the given prefix
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int index = c - 'a';
            if (node.children[index] == null) {
                return false;
            }
            node = node.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();

        // Test insert method
        trie.insert("apple");
        trie.insert("app");

        // Test search method
        System.out.println(trie.search("apple"));  // Output: true
        System.out.println(trie.search("app"));    // Output: true
        System.out.println(trie.search("appl"));   // Output: false

        // Test startsWith method
        System.out.println(trie.startsWith("app")); // Output: true
        System.out.println(trie.startsWith("apl")); // Output: false
    }
}

