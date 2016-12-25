package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/maximum-element
public class MaximumElement {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> vals = new Stack<>();
		vals.push(0);
		for (int i = 0; i < n; i++) {
			int type = in.nextInt();
			if (type == 1) {
				int max = Math.max(in.nextInt(), vals.peek());
				vals.push(max);
			} else if (type == 2) {
				vals.pop();
			} else {
				System.out.println(vals.peek());
			}
		}
	}
	
}
