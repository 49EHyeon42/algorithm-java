import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int countA = Integer.parseInt(st.nextToken());
        int countB = Integer.parseInt(st.nextToken());

        HashSet<String> hashSetA = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countA; i++) {
            hashSetA.add(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < countB; i++) {
            countA += hashSetA.contains(st.nextToken()) ? -1 : 1;
        }

        bw.write(Integer.toString(countA));

        bw.flush();
        bw.close();
    }
}
