package Stack;

class CallStack {
    private static class Frame {
        String functionName;
        Frame next;

        Frame(String name, Frame next) {
            this.functionName = name;
            this.next = next;
        }
    }

    private Frame top = null;

    public void push(String functionName) {
        top = new Frame(functionName, top);
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("No active call to return from");
        String name = top.functionName;
        top = top.next;
        return name;
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("No active call on stack");
        return top.functionName;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        CallStack stack = new CallStack();

        System.out.println("Calling main()...");
        stack.push("main()");

        System.out.println("Calling processOrder()...");
        stack.push("processOrder()");

        System.out.println("Calling calculateTax()...");
        stack.push("calculateTax()");

        System.out.println("Currently executing: " + stack.peek());

        System.out.println("Returning from: " + stack.pop());
        System.out.println("Currently executing: " + stack.peek());
        System.out.println("Returning from: " + stack.pop());
        System.out.println("Returning from: " + stack.pop());

        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
