import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Deque<Integer> deque = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            Integer write = null;
            switch (st.nextToken()) {
                case "push":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    write = (deque.isEmpty()) ? -1 : deque.pollFirst();
                    break;
                case "size":
                    write = deque.size();
                    break;
                case "empty":
                    write = (deque.isEmpty()) ? 1 : 0;
                    break;
                case "front":
                    write = (deque.isEmpty()) ? -1 : deque.peekFirst();
                    break;
                case "back":
                    write = (deque.isEmpty()) ? -1 : deque.peekLast();
                    break;
            }

            if (write != null) {
                sb.append(write).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
