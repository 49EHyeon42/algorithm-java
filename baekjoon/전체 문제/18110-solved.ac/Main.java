import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int round = (int) Math.round(n * 0.15);

        Arrays.sort(array);

        int sum = 0;

        for (int i = round; i < n - round; i++) {
            sum += array[i];
        }

        bw.write(Integer.toString(Math.round(sum / (float) (n - round * 2))));
        bw.flush();

        br.close();
        bw.close();
    }
}
