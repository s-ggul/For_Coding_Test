import java.io.*;

public class counting_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int maxSize = 10001;
        int T = Integer.parseInt(bf.readLine());
        int arr[] = new int[T + 1];
        int sum[] = new int[maxSize];

        for (int i = 1; i <= T; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
            sum[arr[i]]++;
        }
        int total = 0;

        for (int i = 1; i < maxSize; i++) {
            if (sum[i] != 0) {
                total += sum[i];
                sum[i] = total;
            }
        }

        int result[] = new int[T + 1];

        for (int i = T; i >= 1; i--) {
            int index = sum[arr[i]];
            sum[arr[i]]--;
            result[index] = arr[i];
        }
        for (int i = 1; i < result.length; i++) {
            if (result[i] != 0) {
                bw.write(result[i] + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
