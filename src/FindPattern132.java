import java.util.Stack;

public class FindPattern132 {

    public static void main(String[] args) {
        FindPattern132 obj = new FindPattern132();
        int[] nums = {-1,3,2,0};
        System.out.println(obj.find132pattern(nums));
    }
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < num3) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                num3 = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}

// Question Link => https://leetcode.com/problems/132-pattern/