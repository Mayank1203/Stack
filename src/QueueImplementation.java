import java.util.Stack;

    class MyQueue {
        private Stack<Integer> input;
        private Stack<Integer> output;

        // Constructor
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        // Push element x to the back of queue
        public void push(int x) {
            input.push(x);
        }

        // Removes the element from in front of queue and returns that element
        public int pop() {
            peek(); // Ensure output has the current front
            return output.pop();
        }

        // Get the front element
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        // Returns whether the queue is empty
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    public class QueueImplementation {
    // Example usage
        public static void main(String[] args) {
            MyQueue queue = new MyQueue();
            queue.push(1);
            queue.push(2);
            queue.push(3);

            System.out.println(queue.peek()); // Output: 1
            System.out.println(queue.pop());  // Output: 1
            System.out.println(queue.peek()); // Output: 2
            System.out.println(queue.empty()); // Output: false
        }
    }

// Question Link=> https://leetcode.com/problems/implement-queue-using-stacks/
