public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int n1 = 6;
        int[][] vertex1 = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result1 = 3;

        System.out.println("test case 1 = " + (solution.solution(n1, vertex1) == result1));

        // Add test 2
        int n2 = 5;
        int[][] vertex2 = {{1, 2}, {2, 3}, {1, 4}, {4, 5}};
        int result2 = 2;

        System.out.println("test case 2 = " + (solution.solution(n2, vertex2) == result2));
    }
}
