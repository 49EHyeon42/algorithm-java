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

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        List<Integer> coordinate = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coordinate.add(Integer.parseInt(st.nextToken()));
        }

        coordinate.sort(Comparator.comparingInt(o -> o));

        List<Integer> difference = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            difference.add(coordinate.get(i + 1) - coordinate.get(i));
        }

        difference.sort(Comparator.comparingInt(o -> o));

        int total = 0;
        for (int i = 0; i < N - K; i++) {
            total += difference.get(i);
        }

        bw.write(Integer.toString(total));
        bw.flush();

        br.close();
        bw.close();
    }
}
