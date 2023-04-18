public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int[] numbers1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        int result1 = 5;

        System.out.println("test case 1 = " + (solution.solution(numbers1, target1) == result1));

        // test 2
        int[] numbers2 = {4, 1, 2, 1};
        int target2 = 4;
        int result2 = 2;

        System.out.println("test case 2 = " + (solution.solution(numbers2, target2) == result2));

    }
}
