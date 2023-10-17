import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseNumber = 10;

        for (int currentTestCase = 1; currentTestCase <= testCaseNumber; currentTestCase++) {
            int buildingNumber = scanner.nextInt();

            int[] buildings = new int[buildingNumber];

            for (int i = 0; i < buildingNumber; i++) {
                buildings[i] = scanner.nextInt();
            }

            int total = 0;

            for (int i = 2; i < buildingNumber - 2; i++) {
                total += getValue(buildings, i);
            }

            System.out.printf("#%d %d\n", currentTestCase, total);
        }
    }

    private static int getValue(int[] buildings, int currentIndex) {
        int max = -1;

        for (int i = currentIndex - 2; i < currentIndex + 3; i++) {
            if (i == currentIndex) {
                continue;
            }

            if (buildings[i] >= buildings[currentIndex]) {
                return 0;
            }

            max = Math.max(max, buildings[i]);
        }

        return buildings[currentIndex] - max;
    }
}
