import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, PriorityQueue<Integer>> map = new HashMap<>();

        long sum = 0;

        int Q = Integer.parseInt(br.readLine());

        while (Q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String command = st.nextToken();
            String name = st.nextToken();

            if (command.equals("1")) {
                map.computeIfAbsent(name, string -> new PriorityQueue<>(Comparator.reverseOrder()));

                int i = Integer.parseInt(st.nextToken());

                while (i-- > 0) {
                    map.get(name).offer(Integer.parseInt(st.nextToken()));
                }
            } else {
                PriorityQueue<Integer> pq = map.get(name);

                if (pq == null) {
                    continue;
                }

                int i = Integer.parseInt(st.nextToken());

                while (!pq.isEmpty() && i-- > 0) {
                    sum += pq.poll();
                }
            }
        }

        bw.write(Long.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }
}
