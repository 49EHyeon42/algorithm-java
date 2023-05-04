import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public String solution(int N) {
        return N % 2 == 1 ? "SK" : "CY";
    }
}

public class Main {

    // 문제의 "두 사람이 완벽하게 게임을 했을 때" 중 완벽하게 란?

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution solution = new Solution();

        bw.write(solution.solution(Integer.parseInt(br.readLine())));
        bw.flush();

        br.close();
        bw.close();
    }
}
