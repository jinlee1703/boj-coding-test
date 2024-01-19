import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt(); // TC 수

        for (int tc = 0; tc < t; tc++) {
            int m = sc.nextInt(); // 배추밭 가로 길이
            int n = sc.nextInt(); // 배추밭 세로 길이
            int k = sc.nextInt(); // 배추의 개수

            int[][] graph = new int[n][m];

            for (int i = 0; i < k; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                graph[y][x] = 1;
            }

            System.out.println(solution(n, m, graph));
        }
    }

    static int solution(int n, int m, int[][] graph) {
        int answer = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    answer += bfs(n, m, i, j, graph, visited);
                }
            }
        }
        return answer;
    }

    static int bfs(int n, int m, int x, int y, int[][] graph, boolean[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= n || ny < 0 | ny >= m) {
                    continue;
                }

                if (visited[nx][ny]) {
                    continue;
                }

                if (graph[nx][ny] == 1) {
                    queue.add(new Node(nx, ny));
                    visited[nx][ny] = true;
                }
            }
        }

        return 1;
    }

}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}