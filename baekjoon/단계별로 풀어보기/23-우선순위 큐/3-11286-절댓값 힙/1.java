import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

// 25740KB, 364ms
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        PriorityQueue<Integer> positivePriorityQueue = new PriorityQueue<>();
        PriorityQueue<Integer> negativePriorityQueue = new PriorityQueue<>(
            Collections.reverseOrder());

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (positivePriorityQueue.isEmpty() && negativePriorityQueue.isEmpty()) {
                    sb.append(0).append('\n');
                } else if (positivePriorityQueue.isEmpty()) {
                    sb.append(negativePriorityQueue.poll()).append('\n');
                } else if (negativePriorityQueue.isEmpty()) {
                    sb.append(positivePriorityQueue.poll()).append('\n');
                } else {
                    if (positivePriorityQueue.peek() < -negativePriorityQueue.peek()) {
                        sb.append(positivePriorityQueue.poll()).append('\n');
                    } else {
                        sb.append(negativePriorityQueue.poll()).append('\n');
                    }
                }
            } else {
                if (x > 0) {
                    positivePriorityQueue.add(x);
                } else {
                    negativePriorityQueue.add(x);
                }
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
