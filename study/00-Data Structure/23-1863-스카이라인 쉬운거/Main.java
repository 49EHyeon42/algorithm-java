import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ArrayList<Coordinate> arrayList = new ArrayList<>();
        Stack<Coordinate> stack = new Stack<>();

        int coordinateNumber = Integer.parseInt(br.readLine());

        for (int i = 0; i < coordinateNumber; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            arrayList.add(new Coordinate(x, y));
        }
        arrayList.add(new Coordinate(0, 0));

        int answer = 0;

        for (int i = 0; i <= coordinateNumber; i++) {
            int currentY = arrayList.get(i).getY();

            while (!stack.isEmpty() && stack.peek().getY() > currentY) {
                stack.pop();
                answer++;
            }

            if (stack.isEmpty() || stack.peek().getY() != currentY) {
                stack.push(arrayList.get(i));
            }
        }

        bw.write(Integer.toString(answer));

        bw.flush();
        bw.close();
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
