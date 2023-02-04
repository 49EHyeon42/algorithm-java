import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("abcd");
        trie.insert("a");
        trie.insert("qwer");
        trie.insert("er");
        trie.insert("qa");
        trie.insert("hello");

        System.out.println("abc = " + trie.search("abc"));
        System.out.println("abcd = " + trie.search("abcd"));
        System.out.println("q = " + trie.search("q"));
        System.out.println("qa = " + trie.search("qa"));
        System.out.println("hello = " + trie.search("hello"));
    }

    private static class Trie {

        private final Node root = new Node();

        public void insert(String string) {
            Node currentNode = root;

            for (char c : string.toCharArray()) {
                if (!currentNode.child.containsKey(c)) {
                    currentNode.child.put(c, new Node());
                }
                currentNode = currentNode.child.get(c);
            }

            currentNode.isWord = true;
        }

        public boolean search(String string) {
            Node currentNode = root;

            for (char c : string.toCharArray()) {
                if (!currentNode.child.containsKey(c)) {
                    return false;
                }
                currentNode = currentNode.child.get(c);
            }

            return currentNode.isWord;
        }

        private static class Node {

            private boolean isWord;
            private final Map<Character, Node> child = new HashMap<>();
        }
    }
}
