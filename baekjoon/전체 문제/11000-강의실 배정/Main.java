import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startTime = Integer.parseInt(st.nextToken());
            int endTime = Integer.parseInt(st.nextToken());

            lectures.add(new Lecture(startTime, endTime));
        }

        lectures.sort(Comparator.comparingInt(Lecture::getStartTime));

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.offer(lectures.get(0).getEndTime());
        for (int i = 1; i < N; i++) {
            Lecture currentLecture = lectures.get(i);
            if (!pq.isEmpty() && currentLecture.getStartTime() >= pq.peek()) {
                pq.poll();
            }
            pq.offer(currentLecture.getEndTime());
        }

        bw.write(Integer.toString(pq.size()));
        bw.flush();

        br.close();
        bw.close();
    }

    private static class Lecture {

        private final int startTime;
        private final int endTime;

        public Lecture(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}
