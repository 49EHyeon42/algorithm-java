import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                if (st.nextToken().equals("1")) {
                    merge(i, j);
                }
            }
        }

        bw.write(isPossible(br.readLine()) ? "YES" : "NO");

        bw.flush();
        bw.close();
    }

    private static boolean isPossible(String string) {
        StringTokenizer st = new StringTokenizer(string);

        int previousVertex = Integer.parseInt(st.nextToken());

        while (st.hasMoreTokens()) {
            int currentVertex = Integer.parseInt(st.nextToken());

            if (!isUnion(previousVertex, currentVertex)) {
                return false;
            }

            previousVertex = currentVertex;
        }

        return true;
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    private static boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int index) {
        if (parent[index] == index) {
            return index;
        }

        return parent[index] = find(parent[index]);
    }
}
