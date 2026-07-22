package Stack;

class UndoBuffer {
    private String[] data;
    private int top;

    public UndoBuffer(int maxDepth) {
        data = new String[maxDepth];
        top = -1;
    }

    public boolean push(String edit) {
        if (top == data.length - 1) return false; // at capacity: reject
        data[++top] = edit;
        return true;
    }

    public String pop() {
        if (isEmpty()) throw new RuntimeException("Nothing to undo");
        return data[top--];
    }

    public String peek() {
        if (isEmpty()) throw new RuntimeException("Nothing to undo");
        return data[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public static void main(String[] args) {
        UndoBuffer buffer = new UndoBuffer(3);

        System.out.println("Push Action 1: " + buffer.push("Type 'Hello'"));
        System.out.println("Push Action 2: " + buffer.push("Type ' World'"));
        System.out.println("Push Action 3: " + buffer.push("Format Bold"));
        System.out.println("Push Action 4 (over capacity): " + buffer.push("Delete Line")); // Should return false

        System.out.println("Peek top action: " + buffer.peek());
        System.out.println("Pop action: " + buffer.pop());
        System.out.println("Pop action: " + buffer.pop());
        System.out.println("Peek top action: " + buffer.peek());
    }
}
