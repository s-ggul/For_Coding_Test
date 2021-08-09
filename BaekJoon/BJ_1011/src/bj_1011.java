import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());

        for (int i = 0; i < T; i++) {
            String str = bf.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int l = y - x;
            int maxNum = (int) Math.sqrt(l);

            if (maxNum == Math.sqrt(l)) {
                System.out.println(2 * maxNum - 1);
            } else if (l <= maxNum * maxNum + maxNum) {
                System.out.println(2 * maxNum);
            } else if (l > maxNum * maxNum + maxNum) {
                System.out.println(2 * maxNum + 1);
            }
        }
    }
}

