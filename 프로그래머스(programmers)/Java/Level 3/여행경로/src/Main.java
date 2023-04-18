import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // test 1
        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[] result1 = {"ICN", "JFK", "HND", "IAD"};

        System.out.println("test case 1 = " + Arrays.equals(solution.solution(tickets1), result1));

        // test 2
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},
            {"ATL", "SFO"}};
        String[] result2 = {"ICN", "ATL", "ICN", "SFO", "ATL", "SFO"};

        System.out.println("test case 2 = " + Arrays.equals(solution.solution(tickets2), result2));
    }
}
