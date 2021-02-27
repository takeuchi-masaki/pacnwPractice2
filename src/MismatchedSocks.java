import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MismatchedSocks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> p = new PriorityQueue<>(Comparator.reverseOrder());
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int temp = sc.nextInt();
            p.add(temp);
        }
        int curr, pairs = 0;
        while (p.size() > 1) {
            curr = p.poll();
            int next = p.poll();
            int diff = curr - next;
            if (diff >= 0) pairs += next;
            curr -= next;
            while (curr > 0 && !p.isEmpty()) {
                next = p.poll();
                diff = curr - next;
                curr -= next;
                if (diff >= 0) pairs += next;
            }
            if (curr != 0) {
                p.add(Math.abs(curr));
            }
        }
        System.out.println(pairs);
    }
}
