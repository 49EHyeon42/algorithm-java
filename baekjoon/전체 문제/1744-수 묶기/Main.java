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

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        long total = 0;

        int left = 0;
        int right = N - 1;

        while (left < right) {
            if (array[left] < 1 && array[left + 1] < 1) {
                total += (long) array[left] * array[left + 1];
                left += 2;
            } else {
                break;
            }
        }

        while (right > 0) {
            if (array[right] > 1 && array[right - 1] > 1) {
                total += (long) array[right] * array[right - 1];
                right -= 2;
            } else {
                break;
            }
        }

        while (left <= right) {
            total += array[right];
            right--;
        }

        bw.write(Long.toString(total));
        bw.flush();

        br.close();
        bw.close();
    }
}
