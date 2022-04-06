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

    int N = Integer.parseInt(br.readLine());

    int[][] array = new int[N][2];

    StringTokenizer st;
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      array[i][0] = Integer.parseInt(st.nextToken());
      array[i][1] = Integer.parseInt(st.nextToken());
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      int rank = 1;

      for (int j = 0; j < N; j++) {
        if (i == j)
          continue;

        if (array[i][0] < array[j][0] && array[i][1] < array[j][1]) {
          rank++;
        }
      }

      sb.append(rank).append(' ');
    }

    bw.write(sb.toString());

    bw.flush();
    bw.close();
  }
}
