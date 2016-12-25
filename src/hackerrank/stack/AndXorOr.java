package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/and-xor-or
public class AndXorOr {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> st = new Stack<>();
		int max = 0;
		for (int i = 0; i < n; i++) {
			int next = in.nextInt();
			while (!st.isEmpty()) {
				int top = st.peek();
				if ((next ^ top) > max) max = next ^ top;
				if (next < top) st.pop();
				else break;
			}
			st.push(next);
		}
		System.out.println(max);
	}

}
