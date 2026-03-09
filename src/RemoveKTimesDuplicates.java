import java.util.Stack;

public class RemoveKTimesDuplicates {
        public String removeDuplicates(String s, int k) {
            Stack<Character> charSt = new Stack<>();
            Stack<Integer> countSt = new Stack<>();

            for (char ch : s.toCharArray()) {
                if (!charSt.isEmpty() && charSt.peek() == ch) {
                    countSt.push(countSt.peek() + 1);
                } else {
                    countSt.push(1);
                }

                charSt.push(ch);

                if (countSt.peek() == k) {
                    for (int i = 0; i < k; i++) {
                        charSt.pop();
                        countSt.pop();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : charSt) {
                sb.append(c);
            }
            return sb.toString();
        }

        // Example usage
        public static void main(String[] args) {
            RemoveKTimesDuplicates sol = new RemoveKTimesDuplicates();
            String s = "deeedbbcccbdaa";
            int k = 3;
            System.out.println(sol.removeDuplicates(s, k)); // Output: "aa"
        }
    }

// Question Link => https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/