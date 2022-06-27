import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            Integer write = null;
            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    write = (stack.empty()) ? -1 : stack.pop();
                    break;
                case "size":
                    write = stack.size();
                    break;
                case "empty":
                    write = (stack.empty()) ? 1 : 0;
                    break;
                case "top":
                    write = (stack.empty()) ? -1 : stack.peek();
                    break;
            }

            if (write != null) {
                sb.append(write).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}
