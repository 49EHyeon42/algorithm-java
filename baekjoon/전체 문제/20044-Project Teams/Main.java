import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int length = N * 2;

        int[] array = new int[length];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < length; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);

        int min = Integer.MAX_VALUE;

        for (int i = 0, j = length - 1; i < N; i++, j--) {
            min = Math.min(min, array[i] + array[j]);
        }

        bw.write(Integer.toString(min));
        bw.flush();

        br.close();
        bw.close();
    }
}
