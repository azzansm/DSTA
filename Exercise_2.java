// Implement an infix to postfix converter using a stack in Java
// you can use the Java API

import java.util.Scanner;
import java.util.Stack;

public class Exercise_2 {
    private static int precedence(char c) {
        if (c == '*' || c == '/' || c == '%')
            return 3;
        else if (c == '+' || c == '-')
            return 2;
        else if (c == '^')
            return 1;
        else return -1;
    }
    public static String convertToPostfix(String infix) {StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // operations
        postfix = new StringBuilder(); // postfix expression
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        return postfix.toString();
    }

    public static void main(String[] args){
        String input;
        System.out.print("Enter an infix: ");
        Scanner sc = new Scanner(System.in);
        input = sc.nextLine();
        System.out.print("Postfix: " + convertToPostfix(input));
    }
}
