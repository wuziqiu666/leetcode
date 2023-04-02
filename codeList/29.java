import java.util.*;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean isNeg = ((dividend & (1 << 31)) != (divisor & (1 << 31)));
        long ldividend = Math.abs((long)dividend);
        long ldivisor = Math.abs((long)divisor);
        long ans = 0;
        while (ldividend >= ldivisor) {
            long divsum = ldivisor;
            long divnum = 1;
            while (divsum <= ldividend) {
                divsum = divsum << 1;
                divnum = divnum << 1;
            }
            divsum = divsum >> 1;
            divnum = divnum >> 1;
            ldividend = ldividend - divsum;
            ans = ans + divnum;

        }
        return isNeg ? (int) -ans : (int) ans; 

    }
}
    