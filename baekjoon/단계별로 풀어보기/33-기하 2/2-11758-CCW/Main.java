import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    private static final ArrayList<Coordinate> coordinates = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates.add(new Coordinate(x, y));
        }

        bw.write(Integer.toString(ccw()));

        bw.flush();
        bw.close();
    }

    private static int ccw() {
        int x1 = coordinates.get(0).getX();
        int x2 = coordinates.get(1).getX();
        int x3 = coordinates.get(2).getX();
        int y1 = coordinates.get(0).getY();
        int y2 = coordinates.get(1).getY();
        int y3 = coordinates.get(2).getY();

        int a = x1 * y2 + x2 * y3 + x3 * y1;
        int b = y1 * x2 + y2 * x3 + y3 * x1;

        if (a - b > 0) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}

class Coordinate {

    private final int x;
    private final int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
