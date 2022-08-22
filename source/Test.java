import java.util.List;

public class Test {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        Solution solution = new Solution();
        int[] nums = {2,2,1,3};
        List<Integer> ans = solution.majorityElement(nums);

        long endTime = System.currentTimeMillis();
        System.out.println("runtime:" + (endTime- startTime) + "ms");

        System.out.println(ans);

    }
}
