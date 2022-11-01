import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        HashSet<String> hashSet = new HashSet<>();

        while (N-- > 0) {
            char[] array = br.readLine().toCharArray();

            Arrays.sort(array);

            hashSet.add(String.valueOf(array));
        }

        bw.write(Integer.toString(hashSet.size()));
        bw.flush();

        br.close();
        bw.close();
    }
}
