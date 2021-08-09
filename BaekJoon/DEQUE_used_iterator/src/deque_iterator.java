import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class deque_iterator {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < T; i++) {
            int num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                stack.remove();
            } else {
                stack.addFirst(num);
            }
        }
        int sum = 0;
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()) {
            sum += it.next();
        }
        System.out.println(sum);
    }
}
