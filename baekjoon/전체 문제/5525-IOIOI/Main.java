import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int count = 0;

        for (int i = 0; i < M; i++) {
            if (S.charAt(i) == 'O') {
                continue;
            }

            int j = 0; // j = P_1 count

            while (i < M - 2 && S.charAt(i + 1) == 'O' && S.charAt(i + 2) == 'I') {
                j++;

                if (j == N) {
                    j--;
                    count++;
                }

                i += 2;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
