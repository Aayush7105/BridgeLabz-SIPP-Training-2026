package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

class ConfigValidator {

    // Scenario 3: Balanced Brackets — Validating Nested Config Blocks
    public static boolean isValidConfig(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> matchFor = Map.of(')', '(', ']', '[', '}', '{');

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || stack.pop() != matchFor.get(c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String config1 = "{[()]}";
        String config2 = "{[(])}";
        String config3 = "((())";

        System.out.println("Config: " + config1 + " -> Valid? " + isValidConfig(config1));
        System.out.println("Config: " + config2 + " -> Valid? " + isValidConfig(config2));
        System.out.println("Config: " + config3 + " -> Valid? " + isValidConfig(config3));
    }
}
