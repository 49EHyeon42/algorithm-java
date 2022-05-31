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

        int[] array = new int[N + 1];
        int[] dpArray = new int[N + 1];

        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());

            int temp = 0;
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    temp = Math.max(temp, dpArray[j]);
                }
            }

            dpArray[i] = temp + 1;

            answer = Math.max(answer, dpArray[i]);
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
    }
}
