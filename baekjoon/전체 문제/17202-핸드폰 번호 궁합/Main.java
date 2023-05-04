import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Solution {

    public String solution(String A, String B) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            sb.append(A.charAt(i)).append(B.charAt(i));
        }

        String string = sb.toString();

        for (int i = 0; i < 14; i++) {
            StringBuilder temp = new StringBuilder();

            for (int j = 0; j < string.length() - 1; j++) {
                temp.append((Character.getNumericValue(string.charAt(j)) +
                        Character.getNumericValue(string.charAt(j + 1))) % 10);
            }

            string = temp.toString();
        }

        return string;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Solution solution = new Solution();

        bw.write(solution.solution(br.readLine(), br.readLine()));
        bw.flush();

        br.close();
        bw.close();
    }
}
