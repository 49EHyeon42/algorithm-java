import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

// reference : https://etst.tistory.com/318
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Coordinate> coordinates = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if (A > B) {
                coordinates.add(new Coordinate(B, A));
            }
        }

        coordinates.sort(Comparator.comparingInt(Coordinate::getLeft));

        long minLength = M;

        int left = -1;
        int right = -1;
        for (Coordinate coordinate : coordinates) {
            if (coordinate.getLeft() > right) {
                minLength += (right - left) * 2L;

                left = coordinate.getLeft();
                right = coordinate.getRight();
            } else {
                right = Math.max(right, coordinate.getRight());
            }
        }

        minLength += (right - left) * 2L;

        bw.write(Long.toString(minLength));
        bw.flush();
    }
}

class Coordinate {

    private final int left;
    private final int right;

    public Coordinate(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
