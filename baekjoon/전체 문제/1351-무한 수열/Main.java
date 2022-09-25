import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    private static long P;
    private static long Q;

    private static final HashMap<Long, Long> hashMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        hashMap.put(0L, 1L);

        bw.write(Long.toString(dynamic(N)));
        bw.flush();

        br.close();
        bw.close();
    }

    private static long dynamic(long N) {
        if (!hashMap.containsKey(N)) {
            hashMap.put(N, dynamic(N / P) + dynamic(N / Q));
        }
        return hashMap.get(N);
    }
}
