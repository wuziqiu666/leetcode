import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 *
 * https://leetcode-cn.com/problems/binary-watch/description/
 *
 * algorithms
 * Easy (61.78%)
 * Likes:    359
 * Dislikes: 0
 * Total Accepted:    60.7K
 * Total Submissions: 98.2K
 * Testcase Example:  '1'
 *
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或
 * 1，最低位在右侧。
 * 
 * 
 * 例如，下面的二进制手表读取 "3:25" 。
 * 
 * 
 * 
 * 
 * （图源：WikiMedia - Binary clock samui moon.jpg ，许可协议：Attribution-ShareAlike 3.0
 * Unported (CC BY-SA 3.0) ）
 * 
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * 
 * 小时不会以零开头：
 * 
 * 
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 
 * 
 * 分钟必须由两位数组成，可能会以零开头：
 * 
 * 
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * 
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：turnedOn = 9
 * 输出：[]
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 0 
 * 
 * 
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < 0x3ff; i++) {
            int minute = i & 0x3f;
            int hours = i >> 6;
            if (minute < 60 && hours < 12 && Integer.bitCount(i) == turnedOn) {
                ret.add(hours + ":" + (minute > 9 ? "" : "0") + minute);
            }
        }
        return ret;
    }

}
// @lc code=end

