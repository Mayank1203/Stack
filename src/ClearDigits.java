import java.util.Stack;

public class ClearDigits {
    public static void main(String[] args) {
        ClearDigits sol = new ClearDigits();
        System.out.println(sol.clearDigits("abc3d2")); // Output: "ad"
        System.out.println(sol.clearDigits("leetcode123")); // Output: "leet"
    }

    public String clearDigits(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            if (Character.isDigit(s.charAt(i)))
            {
                if (!stack.isEmpty())
                {
                    stack.pop();
                }
            }
            else
            {
                stack.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stack)
        {
            result.append(c);
        }
        return result.toString();
    }
}


// Question Link => https://leetcode.com/problems/clear-digits/