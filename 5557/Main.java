import java.util.Scanner;

public class Main {
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        System.out.println(solution(n, num));
    }

    static long solution(int n, int[] num) {
        long[][] dp = new long[n - 1][21];

        dp[0][num[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                if (j - num[i] >= 0)
                    dp[i][j] += dp[i - 1][j - num[i]];
                if (j + num[i] <= 20)
                    dp[i][j] += dp[i - 1][j + num[i]];
            }
        }

        return dp[n - 2][num[n - 1]];
    }

    // static long dfs(int n, int[] num, int depth, int sum) {
    // if (depth == n - 1) {
    // if (sum == num[n - 1])
    // return 1;
    // else
    // return 0;
    // }

    // long answer = 0;

    // if (sum + num[depth] <= 20)
    // answer += dfs(n, num, depth + 1, sum + num[depth]);
    // if (sum - num[depth] >= 0)
    // answer += dfs(n, num, depth + 1, sum - num[depth]);

    // return answer;
    // }
}
