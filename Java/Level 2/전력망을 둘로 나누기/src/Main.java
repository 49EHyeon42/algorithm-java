public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int n1 = 9;
        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int result1 = 3;

        System.out.println("test case 1 = " + (solution.solution(n1, wires1) == result1));

        // test 2
        int n2 = 4;
        int[][] wires2 = {{1, 2}, {2, 3}, {3, 4}};
        int result2 = 0;

        System.out.println("test case 2 = " + (solution.solution(n2, wires2) == result2));

        // test 3
        int n3 = 7;
        int[][] wires3 = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        int result3 = 1;

        System.out.println("test case 3 = " + (solution.solution(n3, wires3) == result3));
    }
}
