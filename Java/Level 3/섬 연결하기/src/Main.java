public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int n1 = 4;
        int[][] costs1 = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int result1 = 4;

        System.out.println("test case 1 = " + (solution.solution(n1, costs1) == result1));
    }
}
