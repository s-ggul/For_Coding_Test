import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class bint_used {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        BigInteger bint = new BigInteger(a);
        BigInteger bint2 = new BigInteger(b);

        System.out.println(bint.add(bint2));

    }
}

