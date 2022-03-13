import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class counter_queue {
    public static void main(String[] args) throws IOException {
        //입출력 준비 및 필요 변수선언
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            String str1 = bf.readLine();
            StringTokenizer st = new StringTokenizer(str1);
            int N = Integer.parseInt(st.nextToken());
            int indexOfFile = Integer.parseInt(st.nextToken());
            String str2 = bf.readLine();
            StringTokenizer st2 = new StringTokenizer(str2);
            Deque<int[]> qu = new ArrayDeque<>();
            for (int j = 0; j < N; j++) {
                qu.addLast(new int[]{j, Integer.parseInt(st2.nextToken())});
            }
            int[][] result = new int[N][1];
            int count = 0;

            while (!qu.isEmpty()) {
                int[] base = qu.removeFirst();
                boolean flag = true;
                for (int[] other : qu) {
                    if (other[1] > base[1]) {
                        flag = false;
                    }
                }
                if (flag) {
                    count++;
                    if (base[0] == indexOfFile) {
                        break;
                    }
                } else {
                    qu.addLast(base);
                }
            }
            System.out.println(count);
        }
    }
}
