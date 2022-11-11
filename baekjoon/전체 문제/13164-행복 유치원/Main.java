import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<Integer> heights = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights.add(Integer.parseInt(st.nextToken()));
        }

        List<Integer> heightDifferences = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            heightDifferences.add(heights.get(i) - heights.get(i - 1));
        }

        heightDifferences.sort(Comparator.comparingInt(o -> o));

        int minCost = 0;
        for (int i = 0; i < N - K; i++) {
            minCost += heightDifferences.get(i);
        }

        bw.write(Integer.toString(minCost));
        bw.flush();

        br.close();
        bw.close();
    }
}
