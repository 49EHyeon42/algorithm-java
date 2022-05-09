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

        int[] array1 = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array1);

        int M = Integer.parseInt(br.readLine());

        int[] array2 = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            array2[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int low = 0;
            int high = N - 1;
            boolean flag = false;

            while (low <= high) {
                int mid = (low + high) / 2;

                if (array1[mid] == array2[i]) {
                    flag = true;
                    break;
                } else if (array1[mid] < array2[i]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            if (flag) {
                sb.append("1 ");
            } else {
                sb.append("0 ");
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
