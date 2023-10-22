import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int currentTestCase = 1; currentTestCase <= testCase; currentTestCase++) {
            long A = scanner.nextLong();
            long B = scanner.nextLong();

            long i = B - A;

            if (i < 0 || i == 1) {
                i = -1;
            } else if (i == 0) {
                i = 0;
            } else if ((i & 1) == 1) {
                i = (i - 1) / 2;
            } else { // even
                i = i / 2;
            }

            System.out.printf("#%d %d\n", currentTestCase, i);
        }
    }
}
