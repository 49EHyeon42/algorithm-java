import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

    private static int[] array;

    private static final Stack<Integer> stack = new Stack<>();

    private static int iterativeDFS(int startVertex) {
        boolean[] visit = new boolean[array.length];

        stack.clear();

        stack.push(startVertex);

        int count = 0;

        while (!stack.isEmpty()) {
            int nextVertex = stack.pop();

            if (visit[nextVertex]) {
                continue;
            }

            visit[nextVertex] = true;
            stack.push(array[nextVertex]);
            count++;
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        array = new int[N];

        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int maxIndex = 0;
        int maxCount = 0;

        for (int i = 0; i < N; i++) {
            int count = iterativeDFS(i);

            if (maxCount < count) {
                maxIndex = i;
                maxCount = count;
            }
        }

        bw.write(Integer.toString(maxIndex));
        bw.flush();

        br.close();
        bw.close();
    }
}
