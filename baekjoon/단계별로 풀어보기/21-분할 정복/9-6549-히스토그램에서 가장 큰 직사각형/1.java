import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// Brute force : 시간 초과
public class Main {

    private static int width;
    private static int[] length;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String input;
        while (!(input = br.readLine()).equals("0")) {
            StringTokenizer st = new StringTokenizer(input);

            width = Integer.parseInt(st.nextToken());

            length = new int[width];

            for (int i = 0; i < width; i++) {
                length[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(getLargestRectangleArea()).append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static int getLargestRectangleArea() {
        int maxRectangle = -1;

        for (int i = 0; i < width; i++) {
            int minLength = length[i];
            for (int j = i; j < width; j++) {
                minLength = Math.min(minLength, length[j]);
                maxRectangle = Math.max(maxRectangle, (j - i + 1) * minLength);
            }
        }

        return maxRectangle;
    }
}
