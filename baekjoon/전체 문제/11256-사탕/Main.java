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
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                array[i] = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
            }

            Arrays.sort(array);

            int count = 0;

            for (int i = N - 1; i >= 0; i--) {
                J -= array[i];

                count++;

                if (J <= 0) {
                    break;
                }
            }

            sb.append(count).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
