import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int[] c;

    public static void main(String[] args) {
        int n = Integer.parseInt(sc.nextLine());
        int[] current = new int[n];
        int[] target = new int[n];

        int idx = -1;
        for (String s : sc.nextLine().split("")) {
            current[++idx] = Integer.parseInt(s);
        }
        idx = -1;
        for (String s : sc.nextLine().split("")) {
            target[++idx] = Integer.parseInt(s);
        }
        System.out.println(solution(n, current, target));
    }

    static int solution(int n, int[] current, int[] target) {
        int[] c = Arrays.copyOf(current, n);
        c[0] = 1 - c[0];
        c[1] = 1 - c[1];

        int answer = solve(n, current, target);
        int answer2 = solve(n, c, target);
        if (answer2 != -1)
            ++answer2;

        if (answer == -1)
            return answer2;
        else if (answer2 == -1)
            return answer;
        else
            return Math.min(answer, answer2);
    }

    static int solve(int n, int[] current, int[] target) {
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (current[i] != target[i]) {
                ++cnt;
                current[i] = 1 - current[i];
                current[i + 1] = 1 - current[i + 1];
                if (i != n - 2)
                    current[i + 2] = 1 - current[i + 2];

            }
        }
        return current[n - 1] != target[n - 1] ? -1 : cnt;
    }
}