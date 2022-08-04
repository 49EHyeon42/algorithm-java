import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

// reference : https://st-lab.tistory.com/255, 스택
public class Main {

    private static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);

            int width = Integer.parseInt(st.nextToken());

            heights = new int[width];

            for (int i = 0; i < width; i++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getArea(width)).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static long getArea(int length) {
        Stack<Integer> stack = new Stack<>();

        long maxArea = 0;

        for (int i = 0; i < length; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int height = heights[stack.pop()];
                long width = stack.isEmpty() ? i : i - stack.peek() - 1;

                maxArea = Math.max(maxArea, height * width);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int height = heights[stack.pop()];
            long width = stack.isEmpty() ? length : length - stack.peek() - 1;

            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }
}
