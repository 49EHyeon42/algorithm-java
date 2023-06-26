import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    // reference : https://www.slideshare.net/Baekjoon/baekjoon-online-judge-1019

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // end page

        int[] array = new int[10];

        int start = 1; // start page

        int place = 1; // 자리

        // INFO N의 length-1 만큼 반복
        while (start <= N) {
            // 1. end page 의 일의 자리를 0 로 변경
            while (N % 10 != 9 && start <= N) {
                calculate(array, N, place);

                N--;
            }

            // DEBUG System.out.println("start = " + start);

            // 2. start page 가 일의 자리가 바뀐 end page 보다 크거나 같다면 반복 탈출
            if (start >= N) {
                break;
            }

            // 3. start page 의 일의 자리를 9 로 변경
            while (start % 10 != 0 && start <= N) {
                calculate(array, start, place);

                start++;
            }

            // DEBUG System.out.println("start = " + start);

            // 4. 숫자 줄이기
            start /= 10;
            N /= 10;

            // 5. 규칙에 맞게 계산
            for (int i = 0; i < 10; i++) {
                array[i] += (N - start + 1) * place;
                // DEBUG System.out.println("i = " + i + " array[i] = " + array[i]);
            }

            // 6. 자리수 증가 : 1 -> 10 -> 100 ...
            place *= 10;
        }

        StringBuilder sb = new StringBuilder();

        for (int i : array) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }

    private static void calculate(int[] array, int i, int place) {
        while (i > 0) {
            array[i % 10] += place;

            i /= 10;
        }
    }
}
