import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(a, b, c, m));
    }

    static int solution(int a, int b, int c, int m) {
        int answer = 0;

        int time = 0, stress = 0;
        while (time < 24) {
            ++time;
            if (stress + a <= m) {
                answer += b;
                stress += a;
            } else {
                stress = stress - c <= 0 ? 0 : stress - c;
            }
        }

        return answer;
    }
}
