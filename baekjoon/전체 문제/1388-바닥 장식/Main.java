import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] graph = new String[N];
        boolean[][] visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            graph[i] = br.readLine();
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visit[i][j]) {
                    continue;
                }

                if (graph[i].charAt(j) == '-') {
                    int tempJ = j;

                    while (tempJ < M && graph[i].charAt(tempJ) == '-') {
                        visit[i][tempJ++] = true;
                    }
                } else {
                    int tempI = i;

                    while (tempI < N && graph[tempI].charAt(j) == '|') {
                        visit[tempI++][j] = true;
                    }
                }

                count++;
            }
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
