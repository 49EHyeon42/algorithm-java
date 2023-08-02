import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;

    private static Egg[] eggs;

    private static int max = Integer.MIN_VALUE;

    private static void backtracking(int depth) {
        if (depth == N) {
            int count = 0;

            for (int i = 0; i < N; i++) {
                if (eggs[i].durability <= 0) {
                    count++;
                }
            }

            max = Integer.max(max, count);

            return;
        }

        if (eggs[depth].durability <= 0) {
            backtracking(depth + 1);
        } else {
            boolean hit = false;

            for (int i = 0; i < N; i++) {
                if (i == depth || eggs[i].durability <= 0) {
                    continue;
                }

                eggs[depth].durability -= eggs[i].weight;
                eggs[i].durability -= eggs[depth].weight;

                hit = true;

                backtracking(depth + 1);

                eggs[depth].durability += eggs[i].weight;
                eggs[i].durability += eggs[depth].weight;
            }

            if (!hit) {
                backtracking(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        eggs = new Egg[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            eggs[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        backtracking(0);

        bw.write(Integer.toString(max));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Egg {

        int durability;
        int weight;

        Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
