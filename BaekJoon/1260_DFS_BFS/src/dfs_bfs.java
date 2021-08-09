import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class dfs_bfs {
    static int[][] check; //간선 연결상태
    static boolean[] checked; //확인 여부
    static int n; //정점개수
    static int m; //간선개수
    static int start; //시작정점

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        check = new int[1001][1001];
        checked = new boolean[1001];

        for (int i = 0; i < m; i++) {
            String location = br.readLine();
            StringTokenizer st2 = new StringTokenizer(location);
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            check[x][y] = check[y][x] = 1;
        }

        dfs(start);

        checked = new boolean[1001];
        System.out.println();
        bfs();
    }

    private static void dfs(int start) {
        checked[start] = true;
        System.out.print(start + " ");

        for (int i = 1; i <= n; i++) {
            if (check[start][i] == 1 && checked[i] == false) {
                dfs(i);
            }
        }
    }

    private static void bfs() {
        Deque<Integer> q = new ArrayDeque<>();
        q.addFirst(start);
        checked[start] = true;
        System.out.print(start + " ");

        while (!q.isEmpty()) {
            int temp = q.removeLast();

            for (int i = 1; i <= n; i++) {
                if (check[temp][i] == 1 && checked[i] == false) {
                    q.addFirst(i);
                    checked[i] = true;
                    System.out.print(i + " ");
                }
            }
        }

    }
}
