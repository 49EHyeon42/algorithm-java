import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int brown1 = 10;
        int yellow1 = 2;
        int[] result1 = new int[]{4, 3};

        System.out.println("test case 1 = " + Arrays.equals(solution.solution(brown1, yellow1), result1));

        // test 2
        int brown2 = 8;
        int yellow2 = 1;
        int[] result2 = new int[]{3, 3};

        System.out.println("test case 2 = " + Arrays.equals(solution.solution(brown2, yellow2), result2));

        // test 3
        int brown3 = 24;
        int yellow3 = 24;
        int[] result3 = new int[]{8, 6};

        System.out.println("test case 3 = " + Arrays.equals(solution.solution(brown3, yellow3), result3));
    }
}
