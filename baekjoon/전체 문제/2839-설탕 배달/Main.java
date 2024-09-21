import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        bw.write(Integer.toString(solution(N)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int solution(int sugar) {
        int count = 0;

        // sugar가 0이 될 수도 있기 때문에 ">"가 아닌 ">=" 사용, ex: sugar 3
        while (sugar > 0) {
            if (sugar % 5 == 0) {
                count += sugar / 5;
                return count;
            }

            sugar -= 3;

            count++;
        }

        return -1;
    }
}
