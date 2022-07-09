import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<Top> topStack = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            while (!topStack.isEmpty()) {
                if (height < topStack.peek().getHeight()) {
                    sb.append(topStack.peek().getIndex()).append(' ');
                    break;
                }
                topStack.pop();
            }

            if (topStack.isEmpty()) {
                sb.append("0 ");
            }

            topStack.push(new Top(height, i + 1));
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static class Top {

        private final int height;
        private final int index;

        public Top(int height, int index) {
            this.height = height;
            this.index = index;
        }

        public int getHeight() {
            return height;
        }

        public int getIndex() {
            return index;
        }
    }
}
