import java.util.Arrays;

public class MaximumNumberofCoinsYouCanGet {

    public static void main(String[] args) {
        System.out.println(new MaximumNumberofCoinsYouCanGet().maxCoins(new int[]{2,4,1,2,7,8}));
    }
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);

        int mine = 0;
        int n = (piles.length/3);
        int j = 2;

        for (int i = n; i > 0; i--) {
            mine += piles[(3 * i) - j];
            j--;
        }
        return mine;
    }
}
