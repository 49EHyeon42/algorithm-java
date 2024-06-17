import java.io.*;
import java.util.*;

public class Main {

    private static final Queue<String> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        boolean[] array = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = st.nextToken().equals("1");
        }

        String[] split = br.readLine().split(" ");

        for (int i = N - 1; i >= 0; i--) {
            if (array[i]) {
                continue;
            }

            queue.offer(split[i]);
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            queue.offer(st.nextToken());

            sb.append(queue.poll()).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
