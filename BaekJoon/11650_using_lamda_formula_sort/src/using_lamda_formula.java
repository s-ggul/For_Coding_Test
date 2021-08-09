import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class using_lamda_formula {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int xy[][] = new int[T][2];
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(xy, (xy1, xy2) -> {
            if (xy1[0] == xy2[0]) {
                return xy1[1] - xy2[1];
            } else {
                return xy1[0] - xy2[0];
            }
        });
        //compare() 메소드는 첫번째 인자를 기준으로 하여 작은지 혹은 큰지의 유무만을 판단하고 sort에게 맡긴다.
        //위 경우 xy1[0]가 xy2[0]와 같은경우 y좌표가 후자의 y좌표보다 작은지 큰지의 여부만을 반환하면된다.
        // 만일 다른경우 각각의 x좌표가 큰지 혹은 작은지의 여부만 sort() 함수에 넘겨준다.
        // 즉 사용자는 comparator 인터페이스의 compare메소드 만을 구성하여 sort에 넘겨주는 방식.
        for (int i = 0; i < T; i++) {
            System.out.print(xy[i][0] + " ");
            System.out.print(xy[i][1] + "\n");
        }
    }
}
