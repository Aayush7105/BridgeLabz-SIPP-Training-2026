package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class NextBusierDay {

    // Scenario 4: Next Greater Element — Next Higher-Traffic Day for Growth Analysis
    public static int[] nextBusierDay(int[] visitors) {
        int n = visitors.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices of days

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && visitors[i] > visitors[stack.peek()]) {
                answer[stack.pop()] = visitors[i];
            }
            stack.push(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] visitors = {1200, 1500, 1100, 1300, 1800, 1400};
        System.out.println("Daily Visitors: " + Arrays.toString(visitors));

        int[] result = nextBusierDay(visitors);
        System.out.println("Next Busier Day Count: " + Arrays.toString(result));
    }
}
