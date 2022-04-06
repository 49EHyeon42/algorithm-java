import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String stringN = br.readLine();
    int stringLength = stringN.length();
    int N = Integer.parseInt(stringN);

    int answer = 0;
    for (int i = (N - (stringLength * 9)); i < N; i++) {
      int number = i;
      int sum = 0;

      while (number != 0) {
        sum += number % 10;
        number /= 10;
      }

      if (sum + i == N) {
        answer = i;
        break;
      }
    }

    bw.write(String.valueOf(answer));

    bw.flush();
    bw.close();
  }
}
