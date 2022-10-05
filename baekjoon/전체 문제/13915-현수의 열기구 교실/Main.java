import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String stringN;
        while ((stringN = br.readLine()) != null) {
            int N = Integer.parseInt(stringN);

            int[] array = new int[N];

            for (int i = 0; i < N; i++) {
                for (char character : br.readLine().toCharArray()) {
                    array[i] |= 1 << (character - 'a');
                }
            }

            HashSet<Integer> hashSet = new HashSet<>();

            for (int i : array) {
                hashSet.add(i);
            }

            sb.append(hashSet.size()).append('\n');
        }

        bw.write(sb.toString().trim());
        bw.flush();

        br.close();
        bw.close();
    }
}
