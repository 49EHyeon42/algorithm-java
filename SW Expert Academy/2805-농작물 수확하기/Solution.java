import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCaseNumber = scanner.nextInt();

        for (int currentTestCase = 1; currentTestCase <= testCaseNumber; currentTestCase++) {
            int length = scanner.nextInt();

            int halfLength = length / 2;

            int startIndex = halfLength;
            int endIndex = halfLength + 1;

            int result = 0;

            for (int i = 0; i < halfLength; i++) {
                String string = scanner.next();

                for (int j = startIndex; j < endIndex; j++) {
                    result += string.charAt(j) - '0';
                }

                startIndex--;
                endIndex++;
            }

            for (int i = halfLength; i < length; i++) {
                String string = scanner.next();

                for (int j = startIndex; j < endIndex; j++) {
                    result += string.charAt(j) - '0';
                }

                startIndex++;
                endIndex--;
            }

            System.out.printf("#%d %d\n", currentTestCase, result);
        }
    }
}
