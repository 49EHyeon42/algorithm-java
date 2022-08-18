public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test case 1
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(
            "test case 1 = " + solution.solution(participant1, completion1).equals("leo"));

        // test case 2
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(
            "test case 2 = " + solution.solution(participant2, completion2).equals("vinko"));

        // test case 3
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(
            "test case 3 = " + solution.solution(participant3, completion3).equals("mislav"));
    }
}
