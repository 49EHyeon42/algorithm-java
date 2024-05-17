import java.io.*;
import java.util.*;

public class Main {

    private static int tempLeft;
    private static int tempRight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            char[] array = br.readLine().toCharArray();

            if (twoPointer(array, 0, array.length - 1)) {
                sb.append(0).append('\n');
                continue;
            }

            int left = tempLeft;
            int right = tempRight;

            if (twoPointer(array, left + 1, right)) {
                sb.append(1).append('\n');
                continue;
            }

            sb.append(twoPointer(array, left, right - 1) ? 1 : 2).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    public static boolean twoPointer(char[] array, int left, int right) {
        while (left <= right) {
            if (array[left] != array[right]) {
                tempLeft = left;
                tempRight = right;

                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
