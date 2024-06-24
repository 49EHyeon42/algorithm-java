import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        bw.write(Integer.toString(getCount(A, P)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int getCount(int A, int P) {
        int[] visited = new int[1000000];

        int currentValue = A;

        visited[currentValue] = 1;

        while (true) {
            int nextValue = getNextValue(currentValue, P);

            if (visited[nextValue] != 0) {
                return visited[nextValue] - 1;
            }

            visited[nextValue] = visited[currentValue] + 1;

            currentValue = nextValue;
        }
    }

    private static int getNextValue(int value, int P) {
        int newValue = 0;

        String string = Integer.toString(value);

        for (int i = 0; i < string.length(); i++) {
            newValue += (int) Math.pow(string.charAt(i) - '0', P);
        }

        return newValue;
    }
}
