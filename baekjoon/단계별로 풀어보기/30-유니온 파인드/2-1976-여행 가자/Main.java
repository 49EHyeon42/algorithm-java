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
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1 && !isUnion(i, j)) {
                    merge(i, j);
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean isPossible = true;

        int currentCity = Integer.parseInt(st.nextToken());
        for (int i = 1; i < M; i++) {
            int nextCity = Integer.parseInt(st.nextToken());

            if (isUnion(currentCity, nextCity)) {
                currentCity = nextCity;
            } else {
                isPossible = false;
                break;
            }
        }

        bw.write(isPossible ? "YES" : "NO");

        bw.flush();
        bw.close();
    }

    private static void merge(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }

    private static boolean isUnion(int x, int y) {
        return find(x) == find(y);
    }

    private static int find(int index) {
        return (parent[index] == index) ? index : (parent[index] = find(parent[index]));
    }
}
