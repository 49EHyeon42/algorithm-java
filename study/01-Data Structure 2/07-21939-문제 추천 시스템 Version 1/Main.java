import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Question> ascPQ = new PriorityQueue<>();
        PriorityQueue<Question> descPQ = new PriorityQueue<>(Comparator.reverseOrder());
        int[] level = new int[100001];

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());
            int L = Integer.parseInt(st.nextToken());

            ascPQ.offer(new Question(P, L));
            descPQ.offer(new Question(P, L));
            level[P] = L;
        }

        int M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "recommend": {
                    if (Integer.parseInt(st.nextToken()) == 1) {
                        while (level[descPQ.peek().getNumber()] != descPQ.peek().getLevel()) {
                            descPQ.poll();
                        }
                        sb.append(descPQ.peek().getNumber()).append('\n');
                    } else {
                        while (level[ascPQ.peek().getNumber()] != ascPQ.peek().getLevel()) {
                            ascPQ.poll();
                        }
                        sb.append(ascPQ.peek().getNumber()).append('\n');
                    }
                    break;
                }
                case "add": {
                    int P = Integer.parseInt(st.nextToken());
                    int L = Integer.parseInt(st.nextToken());

                    ascPQ.offer(new Question(P, L));
                    descPQ.offer(new Question(P, L));
                    level[P] = L;
                    break;
                }
                case "solved": {
                    int P = Integer.parseInt(st.nextToken());

                    level[P] = 0;
                    break;
                }
            }
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}

class Question implements Comparable<Question> {

    private final int number;
    private final int level;

    public Question(int number, int level) {
        this.number = number;
        this.level = level;
    }

    public int getNumber() {
        return number;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public int compareTo(Question o) {
        if (this.level == o.level) {
            return Integer.compare(this.number, o.number);
        }
        return Integer.compare(this.level, o.level);
    }
}
