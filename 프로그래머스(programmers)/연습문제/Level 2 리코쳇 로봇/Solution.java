import java.util.*;

class Solution {

    private int[][] dyx = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int solution(String[] board) {
        int maxY = board.length;
        int maxX = board[0].length();

        // visit: 최소 이동 횟수
        // visit[i][j] == -1: 도착 불가
        int[][] visit = new int[maxY][maxX];

        int startY = -1;
        int startX = -1;
        int endY = -1;
        int endX = -1;

        for (int i = 0; i < maxY; i++) {
            for (int j = 0; j < maxX; j++) {
                if (board[i].charAt(j) == 'R') { // 'R' 위치
                    startY = i;
                    startX = j;
                } else if (board[i].charAt(j) == 'G') { // 'G' 위치
                    endY = i;
                    endX = j;
                }

                // 최소 이동 횟수 초기회
                visit[i][j] = -1;
            }
        }

        // BFS
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(startY, startX));
        visit[startY][startX] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextY = currentNode.y;
                int nextX = currentNode.x;

                // 가장자리 또는 장애물을 만날 때 까지 이동
                // 연산 최소화
                while (true) {
                    int nextTempY = nextY + dyx[i][0];
                    int nextTempX = nextX + dyx[i][1];

                    if (nextTempY < 0 || nextTempY >= maxY || nextTempX < 0 || nextTempX >= maxX) {
                        break;
                    }

                    if (board[nextTempY].charAt(nextTempX) == 'D') {
                        break;
                    }

                    nextY = nextTempY;
                    nextX = nextTempX;
                }

                // while (0 <= nextY + dyx[i][0] && nextY + dyx[i][0] < maxY && 0 <= nextX + dyx[i][1] && nextX + dyx[i][1] < maxX && board[nextY + dyx[i][0]].charAt(nextX + dyx[i][1]) != 'D') {
                //     nextY = nextY + dyx[i][0];
                //     nextX = nextX + dyx[i][1];
                // }

                int nextMoveCount = visit[currentNode.y][currentNode.x] + 1;

                // 이미 방문했고, 이전 방문보다 더 많은 이동이 필요한 경우, 넘어간다.
                if (visit[nextY][nextX] != -1 && visit[nextY][nextX] < nextMoveCount) {
                    continue;
                }

                queue.offer(new Node(nextY, nextX));
                visit[nextY][nextX] = nextMoveCount;
            }
        }

        return visit[endY][endX];
    }

    private static class Node {
        int y;
        int x;

        Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
