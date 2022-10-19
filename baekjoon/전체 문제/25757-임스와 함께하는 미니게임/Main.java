import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<String, Integer> games = new HashMap<>();
        games.put("Y", 2);
        games.put("F", 3);
        games.put("O", 4);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        String kind = st.nextToken();

        HashSet<String> people = new HashSet<>();
        for (int i = 0; i < N; i++) {
            people.add(br.readLine());
        }

        int count = 0;

        int currentPeople = people.size();
        while (currentPeople + 1 - games.get(kind) >= 0) {
            count++;
            currentPeople += 1 - games.get(kind);
        }

        bw.write(Integer.toString(count));
        bw.flush();

        br.close();
        bw.close();
    }
}
