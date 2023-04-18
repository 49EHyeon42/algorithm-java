public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int result1 = 2;

        System.out.println("test case 1 = " + (solution.solution(n1, computers1) == result1));

        // test 2
        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        int result2 = 1;

        System.out.println("test case 2 = " + (solution.solution(n2, computers2) == result2));
    }
}
