import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

// reference : https://steady-coding.tistory.com/111
public class Main {

    private static int[] parent;
    private static int[] connect;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int F = Integer.parseInt(br.readLine());

            parent = new int[F * 2];
            connect = new int[F * 2];

            for (int j = 0; j < F * 2; j++) {
                parent[j] = j;
                connect[j] = 1;
            }

            int index = 0;
            HashMap<String, Integer> hashMap = new HashMap<>();

            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String id1 = st.nextToken();
                if (!hashMap.containsKey(id1)) {
                    hashMap.put(id1, index++);
                }

                String id2 = st.nextToken();
                if (!hashMap.containsKey(id2)) {
                    hashMap.put(id2, index++);
                }

                sb.append(merge(hashMap.get(id1), hashMap.get(id2))).append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static int merge(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
            connect[x] += connect[y];
        }

        return connect[x];
    }

    private static int find(int index) {
        return (index == parent[index]) ? index : (parent[index] = find(parent[index]));
    }
}
