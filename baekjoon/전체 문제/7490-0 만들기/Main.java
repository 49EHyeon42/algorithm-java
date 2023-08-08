import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    private static int N;

    private static StringBuilder expressionBuffer;

    private static void backtracking(int depth, int number, int sum, int operator, String expression) {
        if (depth == N) {
            if (sum + number * operator == 0) {
                expressionBuffer.append(expression).append('\n');
            }

            return;
        }

        int nextNumeral = depth + 1;

        // ' ', '+', '-'
        backtracking(depth + 1, number * 10 + nextNumeral, sum, operator, expression + " " + nextNumeral);
        backtracking(depth + 1, nextNumeral, sum + number * operator, 1, expression + "+" + nextNumeral);
        backtracking(depth + 1, nextNumeral, sum + number * operator, -1, expression + "-" + nextNumeral);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseCount = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            N = Integer.parseInt(br.readLine());

            expressionBuffer = new StringBuilder();

            backtracking(1, 1, 0, 1, "1");

            sb.append(expressionBuffer).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
