import java.io.*;
import java.util.StringTokenizer;

// 문제 중: 동전 배열의 양 끝에서 벗어나서 양 끝의 동전만 뒤집거나 양 끝의 두 개 동전만 뒤집는 것도 가능하다. 동전을 뒤집는 횟수에 제한은 없다.
// 즉, 모든 동전을 양수 혹은 음수로 변경할 수 있다.

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;

        for (int i = 0; i < N; i++) {
            sum += Math.abs(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            sum += Math.abs(Integer.parseInt(st.nextToken()));
        }

        bw.write(Integer.toString(sum));
        bw.flush();

        br.close();
        bw.close();
    }
}
