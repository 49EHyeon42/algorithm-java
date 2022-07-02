import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());

        int value = Integer.parseInt(br.readLine());

        maxHeap.add(value);
        sb.append(maxHeap.peek()).append('\n');

        for (int i = 1; i < N; i++) {
            value = Integer.parseInt(br.readLine());

            if (maxHeap.size() > minHeap.size()) {
                minHeap.add(value);
            } else {
                maxHeap.add(value);
            }

            if (maxHeap.peek() > minHeap.peek()) {
                int temp = maxHeap.poll();
                maxHeap.add(minHeap.poll());
                minHeap.add(temp);
            }

            sb.append(maxHeap.peek()).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
