import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int[][] array;
    private static int[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N][2];
        dpArray = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            array[i][0] = Integer.parseInt(st.nextToken());
            array[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array, Comparator.comparingInt(o -> o[0]));

        int max = 0;
        for (int i = 0; i < N; i++) {
            max = Math.max(max, LIS(i));
        }

        // N - maximum wire
        bw.write(Integer.toString(N - max));

        bw.flush();
        bw.close();
    }

    private static int LIS(int index) {
        if (dpArray[index] == 0) {
            dpArray[index] = 1;
            for (int i = index + 1; i < N; i++) {
                if (array[index][1] < array[i][1]) {
                    dpArray[index] = Math.max(dpArray[index], LIS(i) + 1);
                }
            }
        }
        return dpArray[index];
    }
}
