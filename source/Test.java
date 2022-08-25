import java.util.List;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();
        int ans = solution.integerBreak(8);

        long endTime = System.currentTimeMillis();
        System.out.println("runtime:" + (endTime - startTime) + "ms");

        System.out.println(ans);

    }
}
