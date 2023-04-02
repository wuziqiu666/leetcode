import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char bracket : s.toCharArray()) {
            if (bracket == '(' || bracket == '[' || bracket == '{') {
                stack.push(bracket);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                switch (bracket) {
                    case ')':
                        if (stack.peek() != '(') {
                            return false;
                        }
                        break;
                    case ']':
                        if (stack.peek() != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (stack.peek() != '{') {
                            return false;
                        }
                        break;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}