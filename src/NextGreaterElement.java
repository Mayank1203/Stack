import java.util.Stack;

public class NextGreaterElement {
        public int[] nextGreaterElements(int[] nums) {
            int n = nums.length;
            int[] ans = new int[n];
            Stack<Integer> stack = new Stack<>();

            // Traverse the array twice (simulate circular behavior)
            for (int i = 2 * n - 1; i >= 0; i--) {
                // Pop elements smaller or equal to current
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[i % n]) {
                    stack.pop();
                }
                // If stack is empty, no greater element exists
                ans[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
                // Push current index
                stack.push(i % n);
            }

            return ans;
        }

        // Example usage
        public static void main(String[] args) {
          NextGreaterElement sol = new NextGreaterElement();
            int[] nums = {1, 2, 1};
            int[] result = sol.nextGreaterElements(nums);

            System.out.print("Output: [");
            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i]);
                if (i < result.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }


    // Question Link -> https://leetcode.com/problems/next-greater-element-ii/