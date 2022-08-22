import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] progresses1 = {93, 30, 55};
        int[] speeds1 = {1, 30, 5};
        int[] result1 = {2, 1};

        System.out.println(
            "test case 1 = " + (Arrays.equals(solution.solution(progresses1, speeds1), result1)));

        // test 2
        int[] progresses2 = {95, 90, 99, 99, 80, 99};
        int[] speeds2 = {1, 1, 1, 1, 1, 1};
        int[] result2 = {1, 3, 2};

        System.out.println(
            "test case 2 = " + (Arrays.equals(solution.solution(progresses2, speeds2), result2)));
    }
}
