import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        ArrayList<Node> list = new ArrayList<>();
        int[] P = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        list.sort(Comparator.comparingInt(Node::getValue));

        for (int i = 0; i < N; i++) {
            P[list.get(i).getIndex()] = i;
        }

        for (int i : P) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();
    }

    private static class Node {

        private final int index;
        private final int value;

        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public int getValue() {
            return value;
        }
    }
}
