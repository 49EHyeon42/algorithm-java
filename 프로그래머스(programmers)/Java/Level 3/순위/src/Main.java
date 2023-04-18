public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int n1 = 5;
        int[][] results1 = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        int result1 = 2;

        System.out.println("test case 1 = " + (solution.solution(n1, results1) == result1));
    }
}
