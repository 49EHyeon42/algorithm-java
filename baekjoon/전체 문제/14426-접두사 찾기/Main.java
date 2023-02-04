import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static final Trie trie = new Trie();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            trie.insert(br.readLine());
        }

        int count = 0;

        for (int i = 0; i < M; i++) {
            if (trie.contains(br.readLine())) {
                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
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
        }

        public boolean contains(String string) {
            Node currentNode = root;

            for (char c : string.toCharArray()) {
                if (!currentNode.child.containsKey(c)) {
                    return false;
                }

                currentNode = currentNode.child.get(c);
            }

            return true;
        }

        private static class Node {

            private final Map<Character, Node> child = new HashMap<>();
        }
    }
}
