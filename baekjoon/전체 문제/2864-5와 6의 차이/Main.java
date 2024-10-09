import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        String stringA = st.nextToken();
        String stringB = st.nextToken();

        int maxA = getNumber(true, stringA);
        int minA = getNumber(false, stringA);
        int maxB = getNumber(true, stringB);
        int minB = getNumber(false, stringB);

        bw.write((minA + minB) + " " + (maxA + maxB));

        bw.flush();
        bw.close();
    }

    private static int getNumber(boolean max, String string) {
        int sum = 0;

        for (int i = string.length() - 1, digit = 1; i >= 0; i--, digit *= 10) {
            int number = string.charAt(i) - '0';

            if (number == 5 && max) {
                number = 6;
            } else if (number == 6 && !max) {
                number = 5;
            }

            sum += number * digit;
        }

        return sum;
    }
}
