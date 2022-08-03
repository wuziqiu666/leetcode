import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start
class Solution {
    public String simplifyPath(String path) {
        String[] pathList = path.split("/");
        Deque<String> deque = new LinkedList<>();
        deque.push("/");
        for(String str : pathList){
            if(".".equals(str) || "".equals(str)){
                continue;
            }else if("..".equals(str)){
                String tmp = deque.peek();
                if(!"/".equals(tmp)){
                    deque.pop();
                }
            }else{
                deque.push(str);
            }
        }
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append("/");
        while(!deque.isEmpty()){
            String tmp = deque.pollLast();
            if(!"/".equals(tmp) && !"".equals(tmp)){
                sBuilder.append(tmp);
                if(!deque.isEmpty()){
                    sBuilder.append("/");
                }
            }
        }
        return sBuilder.toString();
    }
}
// @lc code=end

