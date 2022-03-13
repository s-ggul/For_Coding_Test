import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class string_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String strArr[] = new String[T];

        for (int i = 0; i < T; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (str1, str2) -> {
            if (str1.length() != str2.length()) {
                return str1.length() - str2.length();
            } else {
                return str1.compareTo(str2);
            }
        });
        //단어를 먼저 길이에 맞게 정렬하는 방식.
        //길이가 같은경우엔 자음순으로 비교.

        String same[] = new String[T];
        int count = 0;
        int num = 0;

        while (count != T) {
            String target = strArr[count];
            boolean flag = false;

            for (int i = 0; i < num; i++) {
                if (same[i].equals(target)) {
                    flag = true;
                }
            }

            if (!flag) {
                same[num] = target;
                num++;
            }
            count++;
        }

        for (int i = 0; i < num; i++) {
            System.out.println(same[i]);
        }
    }
}
