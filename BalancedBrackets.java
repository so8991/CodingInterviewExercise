/*
Input Format

The first line contains a single integer, , denoting the number of strings. 
Each line  of the  subsequent lines consists of a single string, , denoting a sequence of brackets.

Constraints

, where  is the length of the sequence.
Each character in the sequence will be a bracket (i.e., {, }, (, ), [, and ]).
Output Format

For each string, print whether or not the string of brackets is balanced on a new line. If the brackets are balanced, print YES; otherwise, print NO.
*/
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BalancedBrackets {
    
    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<expression.length(); i++) {
            char current = expression.charAt(i);
            if(current=='(' || current=='{' || current=='[') {
                stack.push(current);
            } else {
                if(stack.isEmpty()) return false;
                char prev = stack.pop();
                if(prev=='(' && expression.charAt(i)!=')') return false;
                else if (prev=='{' && expression.charAt(i)!='}') return false;
                else if (prev=='[' && expression.charAt(i)!=']') return false;
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
