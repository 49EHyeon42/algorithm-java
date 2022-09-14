import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        long min = 0;

        if (N == 1) {
            int temp = Integer.parseInt(br.readLine());
            min = 0;
        } else {
            PriorityQueue<Long> pq = new PriorityQueue<>();

            while (N-- > 0) {
                pq.offer(Long.parseLong(br.readLine()));
            }

            while (pq.size() > 1) {
                long A = pq.poll();
                long B = pq.poll();

                min += A + B;

                pq.offer(A + B);
            }
        }

        bw.write(Long.toString(min));
        bw.flush();
    }
}
