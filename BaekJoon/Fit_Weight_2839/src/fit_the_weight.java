import java.io.IOException;
import java.util.Scanner;

public class fit_the_weight {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        if (n == 4 || n == 7) {
            System.out.println(-1);
        } else if (n % 5 == 0) {
            System.out.println(n / 5);
        } else if (n % 5 == 1 || n % 5 == 3) {
            System.out.println((n / 5) + 1);
        } else if (n % 5 == 2 || n % 5 == 4) {
            System.out.println((n / 5) + 2);
        } else {
            System.out.println(-1);
        }
    }
}
