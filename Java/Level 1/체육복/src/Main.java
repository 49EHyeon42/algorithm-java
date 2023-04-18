public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        int n1 = 5;
        int[] lost1 = new int[]{2, 4};
        int[] reserve1 = new int[]{1, 3, 5};
        int result1 = 5;

        System.out.println("test case 1 = " + (solution.solution(n1, lost1, reserve1) == result1));

        // test 2
        int n2 = 5;
        int[] lost2 = new int[]{2, 4};
        int[] reserve2 = new int[]{3};
        int result2 = 4;

        System.out.println("test case 2 = " + (solution.solution(n2, lost2, reserve2) == result2));

        // test 3
        int n3 = 3;
        int[] lost3 = new int[]{3};
        int[] reserve3 = new int[]{1};
        int result3 = 2;

        System.out.println("test case 3 = " + (solution.solution(n3, lost3, reserve3) == result3));
    }
}
