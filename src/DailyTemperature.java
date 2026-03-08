import java.util.Stack;

class DailyTemperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>(); // stores indices of temperatures

        for (int i = 0; i < n; i++) {
            // While current temperature is greater than the temperature at the index on top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex; // number of days waited
            }
            stack.push(i); // push current index
        }

        // Remaining indices in stack have no warmer future day, so result[i] stays 0
        return result;
    }

    // Example usage
    public static void main(String[] args) {
        DailyTemperature sol = new DailyTemperature();
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = sol.dailyTemperatures(temperatures);

        System.out.print("Output: [");
        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i]);
            if (i < answer.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}


// Question Link => https://leetcode.com/problems/daily-temperatures/