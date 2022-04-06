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

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] array = new int[N];

    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < array.length; i++) {
      array[i] = Integer.parseInt(st.nextToken());
    }

    int answer = 0;

    loop: for (int i = 0; i < N - 2; i++) {
      if (array[i] > M)
        continue;

      for (int j = i + 1; j < N - 1; j++) {
        if (array[i] + array[j] > M)
          continue;

        for (int k = j + 1; k < N; k++) {
          int temp = array[i] + array[j] + array[k];

          if (M == temp) {
            answer = temp;
            break loop;
          }

          if (answer < temp && temp < M) {
            answer = temp;
          }
        }
      }
    }
    bw.write(String.valueOf(answer));

    bw.flush();
    bw.close();
  }
}
