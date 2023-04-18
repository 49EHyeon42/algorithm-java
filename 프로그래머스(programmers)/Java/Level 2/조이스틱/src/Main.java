public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String name1 = "JEROEN";
        int result1 = 56;

        System.out.println("test case 1 = " + (solution.solution(name1) == result1));

        // test 2
        String name2 = "JAN";
        int result2 = 23;

        System.out.println("test case 2 = " + (solution.solution(name2) == result2));
    }
}
