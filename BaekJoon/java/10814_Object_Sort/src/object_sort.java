import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class object_sort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        User arr[] = new User[T];

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            arr[i] = new User(age, name);
        }

        Arrays.sort(arr, (user1, user2) -> {
            if (user1.age() == user2.age()) {
                return 0;
            } else {
                return user1.age() - user2.age();
            }
        });
        //객체의 값들을 비교하는 람다식

        for (int i = 0; i < T; i++) {
            System.out.print(arr[i].age() + " ");
            System.out.println(arr[i].name());
        }

    }

    private static class User {
        private int age;
        private String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        private int age() {
            return this.age;
        }

        private String name() {
            return this.name;
        }
    }
}
