import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            // Push opening brackets onto the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                // Check if the closing bracket matches the last opening bracket
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        // Valid only if no unmatched opening brackets remain
        return stack.isEmpty();
    }

    // Quick test
    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()"));        // true
        System.out.println(vp.isValid("()[]{}"));    // true
        System.out.println(vp.isValid("(]"));        // false
        System.out.println(vp.isValid("([)]"));      // false
        System.out.println(vp.isValid("{[]}"));      // true
    }
}


// Question Link-> https://leetcode.com/problems/valid-parentheses/
