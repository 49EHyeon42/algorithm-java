import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseNumber = scanner.nextInt();

        for (int currentTestCase = 1; currentTestCase <= testCaseNumber; currentTestCase++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            int temp1 = b - a;
            int temp2 = c - b;

            System.out.printf("#%d %.1f\n", currentTestCase, temp1 == temp2 ? 0 : temp1 > temp2 ? (float) (temp1 - temp2) / 2 : (float) (temp2 - temp1) / 2);
        }
    }
}
