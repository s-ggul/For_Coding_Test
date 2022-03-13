import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class check_sequence {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        int arr[] = new int[T];
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Character> result = new ArrayDeque<>();
        int start = 1;
        int index = 0;
        int num = 0;
        boolean flag = false;

        while (true) {
            if (stack.peekFirst() == null) {
                stack.addFirst(start);
                result.addFirst('+');
                start++;
                continue;
            }

            if (stack.peekFirst() > arr[index]) {
                System.out.println("NO");
                flag = true;
                break;
            } else {
                if (stack.peekFirst() == arr[index]) {
                    num = stack.removeFirst();
                    result.addFirst('-');
                    index++;
                } else {
                    stack.addFirst(start);
                    result.addFirst('+');
                    start++;
                }
            }
            if (index == T) {
                break;
            }
        }

        if (!flag) {
            Iterator<Character> it = result.descendingIterator();

            while (it.hasNext()) {
                System.out.println(it.next());
            }
        }

    }
}