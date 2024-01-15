import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] applicant = new int[n][2];
            for (int j = 0; j < n; j++) {
                applicant[j][0] = sc.nextInt();
                applicant[j][1] = sc.nextInt();
            }
            System.out.println(solution(n, applicant));
        }
    }

    static int solution(int n, int[][] applicant) {
        int answer = 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[applicant[i][0] - 1] = applicant[i][1];
        }

        int bnd = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] < bnd) {
                ++answer;
                bnd = arr[i];
            }
        }

        return answer;
    }
}