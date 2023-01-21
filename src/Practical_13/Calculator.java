package Practical_13;

import java.util.Stack;

public class Calculator {
    private Stack<Double> stack;

    // constructor to initialize stack
    public Calculator() {
        stack = new Stack<>();
    }

    // method to evaluate postfix expression
    public void evaluatePostfix(String postfix) {
        // split the postfix expression into tokens
        String[] tokens = postfix.split(" ");
        for (String token : tokens) {
            // check if token is a number
            if (token.matches("[0-9]+")) {
                // convert string to double and push to stack
                double num = Double.parseDouble(token);
                stack.push(num);
                // print stack contents and push value for debugging
                System.out.println("push(" + num + ") \t\t\t\t\t\t " + num + " \t\t\t\t\t\t\t\t\t " + stack);
            } else {
                // pop two numbers from stack
                double num2 = stack.pop();
                double num1 = stack.pop();
                double result = 0;
                // perform operation based on token
                switch (token) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                    default:
                        // print error message if invalid operator
                        System.out.println("Invalid operator: " + token);
                        return;
                }
                // push result to stack
                stack.push(result);
                // print stack contents and push value for debugging
                System.out.println("push(" + token + ") \t\t\t\t\t\t " + result + " \t\t\t\t\t\t\t\t\t " + stack);
            }
        }
        // print final result
        System.out.println("Result: " + stack.pop());
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String postfix = "4 5 + 1 2 * - 5 /";
        // print column headers for debugging
        System.out.println("Method \t\t\t\t\t\t\t Return Value \t\t\t\t Stack Contents (... -> top)");
        calculator.evaluatePostfix(postfix);
    }
}