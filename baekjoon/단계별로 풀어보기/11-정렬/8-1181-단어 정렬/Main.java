import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] stringArray = new String[N];

        for (int i = 0; i < N; i++) {
            stringArray[i] = br.readLine();
        }

        Arrays.sort(stringArray, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            return o1.length() - o2.length();
        });

        bw.write(stringArray[0] + "\n");
        for (int i = 1; i < N; i++) {
            if (!stringArray[i].equals(stringArray[i - 1])) {
                bw.write(stringArray[i] + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
