import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        RemoveDuplicates sol = new RemoveDuplicates();

        String test1 = "abbaca";
        String test2 = "azxxzy";
        String test3 = "aabbccdde";

        System.out.println("Input: " + test1 + " → Output: " + sol.removeDuplicates(test1));
        System.out.println("Input: " + test2 + " → Output: " + sol.removeDuplicates(test2));
        System.out.println("Input: " + test3 + " → Output: " + sol.removeDuplicates(test3));
    }

    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!st.isEmpty() && st.peek() == c) {
                st.pop();
            } else {
                st.push(c);
            }
        }


        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        return result.reverse().toString();
    }

}

// Question Link -> https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/