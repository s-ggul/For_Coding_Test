import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wordcount_use_equals {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        String arr[] = str.split(" ");
        int count = 0;
        for(int i = 0; i<arr.length; i++){
            if(!arr[i].equals("")){
                count++;
            }
        }
        System.out.println(count);
    }
}
