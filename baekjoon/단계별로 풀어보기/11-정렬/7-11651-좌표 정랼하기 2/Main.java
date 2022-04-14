import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[][] array = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, (a, b) -> {
            if (a[1] == b[1]) { // If the values of Y are the same
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (int i = 0; i < N; i++) {
            bw.write(array[i][0] + " " + array[i][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
