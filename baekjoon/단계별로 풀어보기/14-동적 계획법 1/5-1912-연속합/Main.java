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

        int n = Integer.parseInt(br.readLine());

        int[] array = new int[n];
        int[] dpArray = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int max = dpArray[0] = array[0];
        for (int i = 1; i < n; i++) {
            dpArray[i] = Integer.max(array[i] + dpArray[i - 1], array[i]);
            max = Integer.max(max, dpArray[i]);
        }

        bw.write(Integer.toString(max));

        bw.flush();
        bw.close();
    }
}
