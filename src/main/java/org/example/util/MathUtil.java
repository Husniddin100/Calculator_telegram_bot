package org.example.util;

public class MathUtil {
    public static Integer calculate(String s) {
        String operators[] = s.split("[0-9]+"); // [,+,-,+]
        String numbers[] = s.split("[+-/*]"); // [5,20,15,8]

        int result = Integer.parseInt(numbers[0]);

        for (int i = 1; i < numbers.length; i++) {
            if (operators[i].equals("+")) {
                result += Integer.parseInt(numbers[i]);
            } else if (operators[i].equals("-")) {
                result -= Integer.parseInt(numbers[i]);
            } else if (operators[i].equals("*")) {
                result *= Integer.parseInt(numbers[i]);
            } else if (operators[i].equals("/")) {
                result /= Integer.parseInt(numbers[i]);
            }
        }
        return result;
    }
}
