import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Queue<Integer> queue = new LinkedList<>();

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                queue.add(Integer.parseInt(st.nextToken()));
            }

            int count = 1;
            int max = queue.stream().mapToInt(x -> x).max().getAsInt();
            while (true) {
                if (queue.peek() != max) {
                    queue.add(queue.poll());
                } else {
                    if (M == 0) {
                        sb.append(count).append('\n');
                        break;
                    } else {
                        queue.poll();
                        max = queue.stream().mapToInt(x -> x).max().getAsInt();
                        count++;
                    }
                }

                M--;
                if (M < 0) {
                    M = queue.size() - 1;
                }
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
