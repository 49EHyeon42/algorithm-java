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

        int[] array = new int[10001];
        for (int i = 0; i < N; i++) {
            array[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            for (int j = 0; j < array[i]; j++) {
                sb.append(i).append('\n');
            }
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
