import java.util.Stack;

public class Calculator {

    // Method to evaluate a mathematical expression
    public static double evaluate(String expression) {
        Stack<Double> values = new Stack<>();
        Stack<Character> operators = new Stack<>();
        int i = 0;

        while (i < expression.length()) {
            char currentChar = expression.charAt(i);

            // Skip spaces
            if (currentChar == ' ') {
                i++;
                continue;
            }

            // If the character is a number, process the number
            if (Character.isDigit(currentChar)) {
                StringBuilder sb = new StringBuilder();
                while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                    sb.append(expression.charAt(i));
                    i++;
                }
                values.push(Double.parseDouble(sb.toString()));
            }

            // If the character is '(', push it to the operators stack
            else if (currentChar == '(') {
                operators.push(currentChar);
                i++;
            }

            // If the character is ')', solve the entire expression inside the parentheses
            else if (currentChar == ')') {
                while (operators.peek() != '(') {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.pop(); // Remove '(' from stack
                i++;
            }

            // If the character is an operator (+, -, *, /)
            else if (currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/') {
                while (!operators.isEmpty() && hasPrecedence(currentChar, operators.peek())) {
                    values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
                }
                operators.push(currentChar);
                i++;
            }
        }

        // Apply remaining operators to remaining values
        while (!operators.isEmpty()) {
            values.push(applyOperator(operators.pop(), values.pop(), values.pop()));
        }

        return values.pop(); // The result will be the last value in the stack
    }

    // Method to apply operator on two numbers
    private static double applyOperator(char operator, double b, double a) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero.");
                }
                return a / b;
            default:
                return 0;
        }
    }

    // Method to check operator precedence
    private static boolean hasPrecedence(char operator1, char operator2) {
        if (operator2 == '(' || operator2 == ')') {
            return false;
        }
        if ((operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-')) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        // Testing the calculator with various expressions
        String expression1 = "5 + 3 * 2";
        String expression2 = "(5 + 3) * 2";
        String expression3 = "10 + 2 * (5 + 3) - 4 / 2";

        System.out.println("Result of expression '" + expression1 + "': " + evaluate(expression1));
        System.out.println("Result of expression '" + expression2 + "': " + evaluate(expression2));
        System.out.println("Result of expression '" + expression3 + "': " + evaluate(expression3));
    }
}
