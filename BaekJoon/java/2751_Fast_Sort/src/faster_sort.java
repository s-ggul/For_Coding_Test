import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class faster_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bf.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < T; i++) {
            list.add(Integer.parseInt(bf.readLine()));
        }

        Collections.sort(list);

        for (int x : list) {
            bw.write(x + "\n");
        }
        bw.flush();
        bw.close();
    }
}
