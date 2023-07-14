import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static Ingredient[] ingredients;

    private static int min = Integer.MAX_VALUE;

    // 조합
    private static void backtracking(int depth, int tempS, int tempB) {
        if (depth == N) {
            if (tempS != 1 && tempB != 0) {
                min = Math.min(min, Math.abs(tempS - tempB));
            }
            return;
        }

        backtracking(depth + 1, tempS * ingredients[depth].S, tempB + ingredients[depth].B);
        backtracking(depth + 1, tempS, tempB);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        ingredients = new Ingredient[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i] = new Ingredient(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }

        backtracking(0, 1, 0);

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Ingredient {

        private final int S; // 신맛
        private final int B; // 쓴맛

        public Ingredient(int S, int B) {
            this.S = S;
            this.B = B;
        }
    }
}
