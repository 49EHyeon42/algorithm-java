import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] files = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            files[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(files);

        long sum = 0;

        for (int i = 0; i < N; i++) {
            sum += binarySearch(files, i) - i;
        }

        bw.write(Long.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int binarySearch(int[] files, int targetIndex) {
        int left = targetIndex + 1;
        int right = files.length - 1;

        int result = targetIndex;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (files[mid] * 9 > files[targetIndex] * 10) {
                right = mid - 1;
            } else {
                result = mid;

                left = mid + 1;
            }
        }

        return result;
    }
}
