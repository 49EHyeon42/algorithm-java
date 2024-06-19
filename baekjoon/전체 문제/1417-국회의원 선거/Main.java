import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;

        while (true) {
            int maxValueIndex = findMaxValueIndex(array);

            if (maxValueIndex == 0) {
                break;
            }

            array[maxValueIndex]--;
            array[0]++;
            count++;
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int findMaxValueIndex(int[] array) {
        int maxValue = array[0];
        int maxValueIndex = 0;

        for (int i = 1; i < array.length; i++) {
            // [0]과 [i]의 중 [i]를 선택하기 위해 <= 사용
            if (maxValue <= array[i]) {
                maxValue = array[i];
                maxValueIndex = i;
            }
        }

        return maxValueIndex;
    }
}
