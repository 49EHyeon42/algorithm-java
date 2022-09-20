import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final int MAX_LENGTH = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        int[] F = new int[MAX_LENGTH + 1]; // int[] F = F(Ai) array

        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            F[array[i]]++;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = N - 1; i >= 0; i--) {
            int currentF = F[array[i]];

            while (!stack.isEmpty()) {
                int nextF = F[array[stack.peek()]];

                if (currentF >= nextF) {
                    stack.pop();
                } else {
                    break;
                }
            }

            answer[i] = !stack.isEmpty() ? array[stack.peek()] : -1;

            stack.push(i);
        }

        for (int i : answer) {
            sb.append(i).append(' ');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
