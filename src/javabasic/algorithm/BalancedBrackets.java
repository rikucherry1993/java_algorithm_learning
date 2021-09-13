package javabasic.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedBrackets {

    public static void main(String[] args){
        boolean result = balancedBrackets(")(");
        System.out.println(result);
    }

    public static boolean balancedBrackets(String str) {
        // Write your code here.
        Stack<Character> stack = new Stack<>();
        //traverse the string, put chars into a stack:
        //1.character is not a part of brackets, do not push
        //2.character is the closing brackets of the last character in stack,
        // do not push and do pop().
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put('(',')');
        brackets.put('{','}');
        brackets.put('[',']');

        for (char c : str.toCharArray()) {
            if (!brackets.containsKey(c) && !brackets.containsValue(c)) continue;
            if (!stack.empty() &&
                    (brackets.containsKey(stack.peek()) && c == brackets.get(stack.peek())
                    )){
                stack.pop();
                continue;
            }

            stack.push(c);

        }

        return stack.empty();
    }
}
