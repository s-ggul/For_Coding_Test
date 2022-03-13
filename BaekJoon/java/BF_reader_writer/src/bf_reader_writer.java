import java.io.*;
import java.util.StringTokenizer;

public class bf_reader_writer {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //선언
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bf.readLine();
        int T = Integer.parseInt(str);

        for(int i =0; i<T; i++){
            String str2 = bf.readLine();
            StringTokenizer st = new StringTokenizer(str2);
            int a = Integer.parseInt(st.nextToken()); //첫번째 호출
            int b = Integer.parseInt(st.nextToken());
            bw.write(a+b+"\n");
        }
        bw.flush();
        bw.close();
    }
}