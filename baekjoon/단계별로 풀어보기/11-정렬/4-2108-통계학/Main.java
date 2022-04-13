import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(array);

        bw.write(GetArithmeticMean() + "\n" + GetMedian() + "\n" +
            GetMode() + "\n" + GetRange());

        bw.flush();
        bw.close();
    }

    // 산술평균
    public static int GetArithmeticMean() {
        return (int)Math.round((double)(Arrays.stream(array).sum()) / N);
    }

    // 중앙값
    public static int GetMedian() {
        return array[N / 2];
    }

    // 최빈값
    public static int GetMode() {
        if (N == 1) {
            return array[0];
        }

        int[] frequencyArray = new int[8001];
        for (int i = 0; i < N; i++) {
            frequencyArray[array[i] + 4000]++;
        }

        int maxFrequency = 0;
        for (int i = 0; i < 8001; i++) {
            if (frequencyArray[i] > maxFrequency) {
                maxFrequency = frequencyArray[i];
            }
        }

        int maxIndex = 0;
        boolean flag = false;
        for (int i = 0; i < 8001; i++) {
            if (frequencyArray[i] == maxFrequency) {
                if (flag) {
                    maxIndex = i - 4000;
                    break;
                }
                maxIndex = i - 4000;
                flag = true;
            }
        }

        return maxIndex;
    }

    // 범위
    public static int GetRange() {
        return array[N - 1] - array[0];
    }
}
