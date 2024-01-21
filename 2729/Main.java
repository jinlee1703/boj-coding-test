import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String a = sc.next();
            String b = sc.next();
            System.out.println(solution(a, b));
        }
    }

    static String solution(String a, String b) {
        BigInteger answer = new BigInteger(a, 2).add(new BigInteger(b, 2));
        return answer.toString(2);
    }
}
