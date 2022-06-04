import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static int[][] items;
    private static int[][] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        items = new int[N][2];
        dpArray = new int[N][K + 1];

        for (int[] temp : dpArray) {
            Arrays.fill(temp, -1);
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // items[i][0] = W
            items[i][1] = Integer.parseInt(st.nextToken()); // items[i][1] = V
        }

        bw.write(Integer.toString(recursive(N - 1, K)));

        bw.flush();
        bw.close();
    }

    private static int recursive(int n, int k) {
        if (n < 0) {
            return 0;
        }

        if (dpArray[n][k] == -1) {
            dpArray[n][k] = (k >= items[n][0]) ?
                Math.max(recursive(n - 1, k),
                    recursive(n - 1, k - items[n][0]) + items[n][1]) :
                recursive(n - 1, k);

        }

        return dpArray[n][k];
    }
}
