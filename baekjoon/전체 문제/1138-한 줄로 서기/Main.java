import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());

        int[] result = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            int value = Integer.parseInt(st.nextToken());

            for (int j = 0; j < N; j++) {
                if (value == 0 && result[j] == 0) {
                    result[j] = i;
                    break;
                } else if (result[j] == 0) {
                    value--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i : result) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
