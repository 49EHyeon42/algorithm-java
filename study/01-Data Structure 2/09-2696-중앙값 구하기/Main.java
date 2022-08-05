import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// reference : https://katfun.tistory.com/entry/%EB%B0%B1%EC%A4%80-2696%EB%B2%88-%EC%A4%91%EA%B0%84%EA%B0%92-%EA%B5%AC%ED%95%98%EA%B8%B0
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int M = Integer.parseInt(br.readLine());

            int[] array = new int[M];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                if (j != 0 && j % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                array[j] = Integer.parseInt(st.nextToken());
            }

            ArrayList<Integer> oddvalues = new ArrayList<>();

            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minPq = new PriorityQueue<>();

            for (int j = 0; j < array.length; j++) {
                int value = array[j];

                if (maxPq.isEmpty() && minPq.isEmpty()) {
                    maxPq.offer(value);
                } else if (maxPq.size() > minPq.size()) {
                    if (value < maxPq.peek()) {
                        minPq.offer(maxPq.poll());
                        maxPq.offer(value);
                    } else {
                        minPq.offer(value);
                    }
                } else if (maxPq.size() == minPq.size()) {
                    if (value > maxPq.peek()) {
                        minPq.offer(value);
                        maxPq.offer(minPq.poll());
                    } else {
                        maxPq.offer(value);
                    }
                }

                if (j % 2 == 0) {
                    oddvalues.add(maxPq.peek());
                }
            }

            sb.append(oddvalues.size()).append('\n');
            for (int j = 0; j < oddvalues.size(); j++) {
                if (j != 0 && j % 10 == 0) {
                    sb.append('\n');
                }
                sb.append(oddvalues.get(j)).append(' ');
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
