/* 조합으로 풀이 접근
 * 실패, 시간초과
 * */
class Solution1 {

    private int[] array;
    private int n;
    private int budget;

    private boolean[] visit;

    private boolean flag;

    public int solution(int[] d, int budget) {
        array = d;
        n = d.length;
        this.budget = budget;

        for (int i = d.length; i >= 0; i--) {
            visit = new boolean[d.length];

            combination(i, 0, 0);

            if (flag) {
                return i;
            }
        }

        return -1;
    }

    private void combination(int depth, int index, int sum) {
        if (depth == 0) {
            flag = sum == budget;
            return;
        }

        for (int i = index; i < n; i++) {
            visit[i] = true;
            combination(depth - 1, i + 1, sum + array[i]);

            if (flag) {
                return;
            }

            visit[i] = false;
        }
    }
}
