import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int maxProfit = 0;

        for (int i = N - 1, max = 0; i >= 0; i--) {
            max = Math.max(max, array[i]);
            maxProfit = Math.max(maxProfit, max - array[i]);
        }

        bw.write(Integer.toString(maxProfit));
        bw.flush();

        br.close();
        bw.close();
    }
}
