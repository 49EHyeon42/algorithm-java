import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

// reference : https://nahwasa.com/entry/%EB%B0%B1%EC%A4%80-22866-%EC%9E%90%EB%B0%94-%ED%83%91-%EB%B3%B4%EA%B8%B0-BOJ-22866-JAVA?category=1049955?category=1049955
public class Main {

    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int buildingNumber = Integer.parseInt(br.readLine());

        ArrayList<Building> buildings = new ArrayList<>();
        buildings.add(new Building(INF, INF));

        int[] visibleBuildings = new int[buildingNumber + 1];

        int[][] distance = new int[buildingNumber + 1][2];
        for (int[] row : distance) {
            Arrays.fill(row, INF);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= buildingNumber; i++) {
            int height = Integer.parseInt(st.nextToken());

            buildings.add(new Building(i, height));
        }

        Stack<Building> stack = new Stack<>();
        for (int i = 1; i <= buildingNumber; i++) {
            Building currentBuilding = buildings.get(i);

            while (!stack.isEmpty()
                && stack.peek().getHeight() <= currentBuilding.getHeight()) {
                stack.pop();
            }

            visibleBuildings[i] = stack.size();

            if (!stack.isEmpty()) {
                int abs = Math.abs(stack.peek().getNumber() - i);

                if (abs < distance[i][1]) {
                    distance[i][0] = stack.peek().getNumber();
                    distance[i][1] = abs;
                } else if (abs == distance[i][1]
                    && stack.peek().getNumber() < distance[i][0]) {
                    distance[i][0] = stack.peek().getNumber();
                }
            }

            stack.push(currentBuilding);
        }

        stack = new Stack<>();
        for (int i = buildingNumber; i >= 1; i--) {
            Building currentBuilding = buildings.get(i);

            while (!stack.isEmpty()
                && stack.peek().getHeight() <= currentBuilding.getHeight()) {
                stack.pop();
            }

            visibleBuildings[i] += stack.size();

            if (!stack.isEmpty()) {
                int abs = Math.abs(stack.peek().getNumber() - i);

                if (abs < distance[i][1]) {
                    distance[i][0] = stack.peek().getNumber();
                    distance[i][1] = abs;
                } else if (abs == distance[i][1]
                    && stack.peek().getNumber() < distance[i][0]) {
                    distance[i][0] = stack.peek().getNumber();
                }
            }

            stack.push(currentBuilding);
        }

        for (int i = 1; i <= buildingNumber; i++) {
            if (visibleBuildings[i] == 0) {
                sb.append(0);
            } else {
                sb.append(visibleBuildings[i]).append(' ').append(distance[i][0]);
            }
            sb.append('\n');
        }

        bw.write(sb.toString().trim());

        bw.flush();
        bw.close();
    }
}

class Building {

    private final int number;
    private final int height;

    public Building(int number, int height) {
        this.number = number;
        this.height = height;
    }

    public int getNumber() {
        return number;
    }

    public int getHeight() {
        return height;
    }
}
