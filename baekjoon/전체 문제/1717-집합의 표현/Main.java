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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                merge(a, b);
            } else {
                sb.append(isUnion(a, b) ? "YES" : "NO").append('\n');
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
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
