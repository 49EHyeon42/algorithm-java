public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String s1 = "()()";
        boolean answer1 = true;

        System.out.println("test case 1 = " + (solution.solution(s1) == answer1));

        // test 2
        String s2 = "(())()";
        boolean answer2 = true;

        System.out.println("test case 2 = " + (solution.solution(s2) == answer2));

        // test 3
        String s3 = ")()(";
        boolean answer3 = false;

        System.out.println("test case 3 = " + (solution.solution(s3) == answer3));

        // test 4
        String s4 = "(()(";
        boolean answer4 = false;

        System.out.println("test case 4 = " + (solution.solution(s4) == answer4));
    }
}
