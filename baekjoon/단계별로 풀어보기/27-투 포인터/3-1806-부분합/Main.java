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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] array = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int low = 0;
        int high = 0;
        int sum = array[0];
        int len = N + 1;

        while (low <= high && high < N) {
            if (sum < S) {
                sum += array[++high];
            } else {
                len = Math.min(len, high - low + 1);
                sum -= array[low++];
            }
        }

        if (len == N + 1) {
            len = 0;
        }

        bw.write(Integer.toString(len));

        bw.flush();
        bw.close();
    }
}
