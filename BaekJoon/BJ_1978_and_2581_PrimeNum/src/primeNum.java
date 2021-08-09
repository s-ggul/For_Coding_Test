import java.io.IOException;
import java.util.Scanner;

public class primeNum {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int M = scan.nextInt();
        int N = scan.nextInt();
        int count = 0;
        int sum = 0;
        int min = 0;

        for (int i = M; i <= N; i++) {
            if (checkPrime(i) == true) {
                count++;
                sum += i;
                if (count == 1) {
                    min = i;
                }
            }
        }
        if (count == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }

    private static boolean checkPrime(int num) {
        double n = Math.sqrt(num);
        if (num == 1) {
            return false;
        }
        for (int i = 2; i <= n; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
    /* 에라토스테네스의 체 방식
    *  private static boolean[] checkPrime(int M, int N) {
        boolean arr[] = new boolean[N+1];

        for (int i = 2; i <= N; i++) {
            if(arr[i] == true){
                continue;
            }
            arr[0] = true;
            arr[1] = true;

            for(int j = i*2; j <= N; j+=i){
                arr[j] = true;
            }
        }
        return arr;
    }
    * */
}

