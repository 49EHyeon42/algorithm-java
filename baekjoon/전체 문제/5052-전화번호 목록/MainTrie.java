import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class MainTrie {

    private static final Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = br.readLine();
                trie.insert(strings[i]);
            }

            sb.append(getString(strings)).append('\n');

            trie.clear();
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static String getString(String[] strings) {
        for (String string : strings) {
            if (!trie.isPossible(string)) {
                return "NO";
            }
        }
        return "YES";
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

        // search method
        public boolean isPossible(String string) {
            Node currentNode = root;

            for (char c : string.toCharArray()) {
                if (currentNode.child.containsKey(c)) {
                    if (currentNode.isWord) {
                        return false;
                    }

                    currentNode = currentNode.child.get(c);
                }
            }

            return true;
        }

        public void clear() {
            root.child.clear();
        }

        private static class Node {

            private boolean isWord;
            private final Map<Character, Node> child = new HashMap<>();
        }
    }
}
