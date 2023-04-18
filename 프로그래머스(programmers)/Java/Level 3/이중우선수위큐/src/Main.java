import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String[] operations1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] result1 = {0, 0};

        System.out.println(
            "test case 1 = " + (Arrays.equals(solution.solution(operations1), result1)));

        // test 2
        String[] operations2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1",
            "I 333"};
        int[] result2 = {333, -45};

        System.out.println(
            "test case 2 = " + (Arrays.equals(solution.solution(operations2), result2)));
    }
}
