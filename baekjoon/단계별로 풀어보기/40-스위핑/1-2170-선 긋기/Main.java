import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            coordinates.add(new Coordinate(x, y));
        }

        coordinates.sort(Comparator.comparingInt(Coordinate::getX));

        int count = 0;

        int left = -1000000001;
        int right = -1000000001;
        for (int i = 0; i < N; i++) {
            Coordinate coordinate = coordinates.get(i);

            if (right < coordinate.getX()) {
                count += right - left;

                left = coordinate.getX();
            }

            if (right < coordinate.getY()) {
                right = coordinate.getY();
            }
        }

        count += right - left;

        bw.write(Integer.toString(count));
        bw.flush();
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
