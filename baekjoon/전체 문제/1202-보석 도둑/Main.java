import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Jewelry> jewels = new ArrayList<>();
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels.add(new Jewelry(M, V));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        jewels.sort((o1, o2) -> {
            if (o1.getWeight() == o2.getWeight()) {
                return o2.getPrice() - o1.getPrice();
            }
            return o1.getWeight() - o2.getWeight();
        });

        Arrays.sort(bags);

        long maxPrice = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0, index = 0; i < K; i++) {
            while (index < N && jewels.get(index).getWeight() <= bags[i]) {
                pq.offer(jewels.get(index++).getPrice());
            }

            if (!pq.isEmpty()) {
                maxPrice += pq.poll();
            }
        }

        bw.write(Long.toString(maxPrice));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Jewelry {

        private final int weight;
        private final int price;

        public Jewelry(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        public int getWeight() {
            return weight;
        }

        public int getPrice() {
            return price;
        }
    }
}
