import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// reference : https://st-lab.tistory.com/255
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

            sb.append(getArea(0, width - 1)).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static long getArea(int start, int end) {
        if (start == end) {
            return heights[start];
        }

        int mid = (start + end) / 2;

        long leftArea = getArea(start, mid);
        long rightArea = getArea(mid + 1, end);

        long maxArea = Math.max(leftArea, rightArea);

        maxArea = Math.max(maxArea, getMidArea(start, end, mid));

        return maxArea;
    }

    public static long getMidArea(int start, int end, int mid) {
        int toLeft = mid;
        int toRight = mid;

        long height = heights[mid];

        long maxArea = height;

        while (start < toLeft && toRight < end) {
            if (heights[toLeft - 1] < heights[toRight + 1]) {
                toRight++;
                height = Math.min(height, heights[toRight]);
            } else {
                toLeft--;
                height = Math.min(height, heights[toLeft]);
            }

            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (toRight < end) {
            toRight++;
            height = Math.min(height, heights[toRight]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        while (start < toLeft) {
            toLeft--;
            height = Math.min(height, heights[toLeft]);
            maxArea = Math.max(maxArea, height * (toRight - toLeft + 1));
        }

        return maxArea;
    }
}
