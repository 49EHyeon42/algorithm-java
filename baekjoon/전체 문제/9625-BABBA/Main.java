import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public String solution(int K) {
        int aOfNumber = 1;
        int bOfNumber = 0;

        while (K-- > 0) {
            int temp = aOfNumber;
            aOfNumber = bOfNumber;
            bOfNumber += temp;
        }

        return String.format("%d %d", aOfNumber, bOfNumber);
    }
}

public class Main {

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
