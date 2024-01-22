import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int[] numbers = new int[n];

    for (int i = 0; i < n; i++) {
      numbers[i] = sc.nextInt();
    }

    System.out.println(solution(n, numbers));
  }

  static int solution(int n, int[] numbers) {
    int answer = 0;
    Queue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < n; i++) {
      queue.add(numbers[i]);
    }

    while (queue.size() > 1) {
      int a = queue.poll();
      int b = queue.poll();
      answer += a + b;
      queue.add(a + b);
    }

    return answer;
  }
}
