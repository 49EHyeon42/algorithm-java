import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

// reference : https://blog.naver.com/PostView.naver?blogId=jinhan814&logNo=222533596191&parentCategoryNo=&categoryNo=11&viewDate=&isShowPopularPosts=false&from=postView
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> segment = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int origin = Integer.parseInt(st.nextToken());
            int radius = Integer.parseInt(st.nextToken());

            segment.add(new Point(origin - radius, true, i));
            segment.add(new Point(origin + radius, false, i));
        }

        segment.sort(Comparator.comparingInt(Point::getCoordinate));

        bw.write((isContact(segment) ? "NO" : "YES"));

        bw.flush();
        bw.close();
    }

    private static boolean isContact(ArrayList<Point> segment) {
        for (int i = 1; i < segment.size(); i++) {
            // 외접 또는 내접 하는 경우
            if (segment.get(i - 1).getCoordinate() == segment.get(i).getCoordinate()) {
                return true;
            }
        }
        Stack<Integer> stack = new Stack<>();

        for (Point point : segment) {
            if (point.isLeft()) {
                stack.push(point.getIndex());
            } else if (stack.peek() != point.getIndex()) { // 서로 다른 원인 경우
                return true;
            } else {
                stack.pop();
            }
        }

        return false;
    }

    public static class Point {

        private final int coordinate;
        private final boolean isLeft;
        private final int index;

        public Point(int coordinate, boolean isLeft, int index) {
            this.coordinate = coordinate;
            this.isLeft = isLeft;
            this.index = index;
        }

        public int getCoordinate() {
            return coordinate;
        }

        public boolean isLeft() {
            return isLeft;
        }

        public int getIndex() {
            return index;
        }
    }
}
