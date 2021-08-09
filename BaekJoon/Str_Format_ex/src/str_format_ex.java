import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class str_format_ex {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        double avg[] = new double[T];

        for (int i = 0; i < T; i++) {
            int sum = 0;
            double mean = 0;
            double avgEach = 0;
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line, " ");
            int C = Integer.parseInt(st.nextToken());
            double num[] = new double[C];
            for (int j = 0; j < C; j++) {
                num[j] = Integer.parseInt(st.nextToken());
                sum += num[j];
                if (j == C - 1) {
                    avgEach = sum / C;
                    for(int k = 0; k < C; k++){
                        if(num[k] > avgEach){
                            mean++;
                        }
                    }
                    avg[i] = mean/C * 100;
                }
            }
            String ratio = String.format("%.3f",(float)avg[i]);
            System.out.println(ratio+"%");
        }
    }
}