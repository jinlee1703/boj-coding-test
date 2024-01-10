import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static int MINUS = 0;
    static int ZERO = 0;
    static int PLUS = 0;

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[][] paper = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        int[] answer = solution(n, paper);
        for (int a : answer) {
            System.out.println(a);
        }
    }

    static int[] solution(int n, int[][] paper) {
        recursive(n, paper, 0, 0);
        return new int[] { MINUS, ZERO, PLUS };
    }

    static void recursive(int size, int[][] paper, int x, int y) {
        if (isOne(size, paper, x, y)) {
            if (paper[x][y] == -1) {
                ++MINUS;
            } else if (paper[x][y] == 0) {
                ++ZERO;
            } else if (paper[x][y] == 1) {
                ++PLUS;
            }
        } else {
            size /= 3;
            recursive(size, paper, x, y);
            recursive(size, paper, x + size, y);
            recursive(size, paper, x + size * 2, y);

            recursive(size, paper, x, y + size);
            recursive(size, paper, x + size, y + size);
            recursive(size, paper, x + size * 2, y + size);

            recursive(size, paper, x, y + size * 2);
            recursive(size, paper, x + size, y + size * 2);
            recursive(size, paper, x + size * 2, y + size * 2);
        }
    }

    static boolean isOne(int size, int[][] paper, int x, int y) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != paper[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
}