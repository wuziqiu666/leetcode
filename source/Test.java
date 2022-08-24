import java.util.List;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();
        int[] coins = { 186, 419, 83, 408 };
        int ans = solution.coinChange(coins, 6249);

        long endTime = System.currentTimeMillis();
        System.out.println("runtime:" + (endTime - startTime) + "ms");

        System.out.println(ans);

    }
}
