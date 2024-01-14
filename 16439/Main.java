import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] chicken = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                chicken[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution(n, m, chicken));
    }

    static int solution(int n, int m, int[][] chicken) {
        int answer = 0;

        boolean[] visited = new boolean[m];
        answer = Math.max(answer, dfs(chicken, n, m, 0, visited));

        return answer;
    }

    static int dfs(int[][] chicken, int n, int m, int depth, boolean[] visited) {
        if (depth == 3) {
            int[] max = new int[n];

            for (int i = 0; i < m; i++) {
                if (visited[i]) {
                    for (int j = 0; j < n; j++) {
                        max[j] = Math.max(max[j], chicken[j][i]);
                    }
                }
            }
            return Arrays.stream(max).sum();
        }

        int answer = 0;

        for (int i = 0; i < m; i++) {
            if (!visited[i]) {
                visited[i] = true;
                answer = Math.max(answer, dfs(chicken, n, m, depth + 1, visited));
                visited[i] = false;
            }
        }
        return answer;
    }
}
