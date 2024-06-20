import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String X = br.readLine();

        int count = 0;

        while (X.length() != 1) {
            int sum = 0;

            for (int i = 0; i < X.length(); i++) {
                sum += charToInt(X.charAt(i));
            }

            X = Integer.toString(sum);

            count++;
        }

        bw.write(count + "\n" + (Integer.parseInt(X) % 3 == 0 ? "YES" : "NO"));
        bw.flush();

        br.close();
        bw.close();
    }

    private static int charToInt(char c) {
        return c - '0';
    }
}
