class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    /** Initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    /** Push element x onto stack. */
    public void push(int val) {
        stack.push(val);
        // If minStack is empty or the new value is smaller or equal to the current minimum, push it onto minStack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }
/** Removes the element on the top of the stack. */
    public void pop() {
        if (stack.isEmpty()) return;
        int popped = stack.pop();
        // If the popped element is the same as the top of minStack, pop it from minStack as well
        if (popped == minStack.peek()) {
            minStack.pop();
        }
    }

    /** Get the top element. */
    public int top() {
        return stack.peek();
    }

    /** Retrieve the minimum element in the stack. */
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */