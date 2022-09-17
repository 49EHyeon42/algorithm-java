import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 시간초과
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewelry> jewels = new PriorityQueue<>(
            Comparator.comparingInt(Jewelry::getWeight));

        PriorityQueue<Integer> bags = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            jewels.add(new Jewelry(M, V));
        }

        for (int i = 0; i < K; i++) {
            int C = Integer.parseInt(br.readLine());

            bags.add(C);
        }

        long maxPrice = 0;

        while (!bags.isEmpty()) {
            int currentBagWeight = bags.poll();

            while (!jewels.isEmpty()) {
                if (currentBagWeight >= jewels.peek().getWeight()) {
                    maxPrice += jewels.poll().getPrice();
                    break;
                }
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
