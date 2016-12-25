package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/balanced-brackets
public class BalancedBrackets {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		while (n-- > 0) {
			if (solve(in.next())) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}

	private static boolean solve(String brackets) {
		Stack<Character> st = new Stack<>();
		for (char c: brackets.toCharArray()) {
			if (c == '(' || c == '[' || c == '{') {
				st.push(c);
			} else if (st.isEmpty()){
				return false;
			} else if (c == ')' && st.pop() != '(') {
				return false;
			} else if (c == ']' && st.pop() != '[') {
				return false;
			} else if (c == '}' && st.pop() != '{') {
				return false;
			}
		}
		return st.isEmpty();
	}

}
