import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] greenOnions = new int[S];

        long totalGreenOnionLength = 0;

        // right를 받기 위해 위에서 선언
        int left = 1;
        int right = 0;

        for (int i = 0; i < S; i++) {
            greenOnions[i] = Integer.parseInt(br.readLine());

            totalGreenOnionLength += greenOnions[i];

            right = Math.max(right, greenOnions[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cutGreenOnions(greenOnions, mid) < C) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        bw.write(Long.toString(totalGreenOnionLength - (long) right * C));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int cutGreenOnions(int[] greenOnions, int selectedGreenOnionLength) {
        int quotient = 0;

        for (int greenOnionLength : greenOnions) {
            quotient += greenOnionLength / selectedGreenOnionLength;
        }

        return quotient;
    }
}
