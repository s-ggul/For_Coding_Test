import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class find_mode {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int arr[] = new int[T];
        int count[] = new int[8001];
        int sum = 0;
        for (int i = 0; i < T; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            count[4000 + arr[i]]++;
        }
        Arrays.sort(arr);

        double num1 = Math.round((double) sum / (double) T);
        int num2 = arr[T / 2];
        int num3;
        int num4 = arr[T - 1] - arr[0];

        int maxCount = 0;
        Deque<Integer> list = new ArrayDeque<>();

        for (int i = 0; i < count.length; i++) {
            if (count[i] >= maxCount) {
                maxCount = count[i];
            }
        }

        for (int i = 0; i < count.length; i++) {
            if (count[i] == maxCount) {
                list.addLast(i - 4000);
            }
        }

        if (list.size() == 1) {
            num3 = list.removeFirst();
        } else {
            list.removeFirst();
            num3 = list.removeFirst();
        }

        System.out.println((int) num1);
        System.out.println(num2);
        System.out.println(num3);
        System.out.println(num4);
    }
}
