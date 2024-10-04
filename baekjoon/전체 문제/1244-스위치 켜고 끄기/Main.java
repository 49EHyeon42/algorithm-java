import java.io.*;
import java.util.*;

public class Main {

    private static boolean[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        array = new boolean[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken()) == 1;
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int index = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                command1(index);
            } else {
                command2(index);
            }
        }

        bw.write(arrayToString());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void command1(int index) {
        for (int i = index; i < array.length; i += index) {
            array[i] ^= true;
        }
    }

    private static void command2(int index) {
        array[index] ^= true;

        int left = index - 1;
        int right = index + 1;

        while (left > 0 && right < array.length) {
            if (array[left] != array[right]) {
                break;
            }

            array[left] ^= true;
            array[right] ^= true;

            left--;
            right++;
        }
    }

    private static String arrayToString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < array.length; i++) {
            sb.append(array[i] ? 1 : 0).append(' ');

            if (i % 20 == 0) {
                sb.append('\n');
            }
        }

        return sb.toString().trim();
    }
}
