import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] array = new String[N];

        for (int i = 0; i < N; i++) {
            array[i] = br.readLine();
        }

        int length = array[0].length();

        Set<String> set = new HashSet<>();

        int count = 0;

        for (int i = length - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                set.add(array[j].substring(i, length));
            }

            if (set.size() == N) {
                break;
            }

            set.clear();

            count++;
        }

        bw.write(Integer.toString(count + 1));
        bw.flush();

        br.close();
        bw.close();
    }
}
