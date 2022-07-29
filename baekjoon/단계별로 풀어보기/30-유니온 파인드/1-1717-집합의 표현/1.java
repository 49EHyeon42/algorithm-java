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
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            if (Integer.parseInt(st.nextToken()) == 0) {
                merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            } else {
                if (isUnion(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))) {
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }

    private static void merge(int x, int y) {
        int tempX = find(x);
        int tempY = find(y);
        if (tempX != tempY) {
            parent[tempY] = tempX;
        }
    }

    private static boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }
}
