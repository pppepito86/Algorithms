package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

//https://www.hackerrank.com/challenges/maximum-element
public class MaximumElement2 {
	
	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> vals = new Stack<>();
		Stack<Integer> max = new Stack<>();
		max.push(0);
		for (int i = 0; i < n; i++) {
			int type = in.nextInt();
			if (type == 1) {
				vals.push(in.nextInt());
				if (vals.peek() >= max.peek()) max.push(vals.peek());
			} else if (type == 2) {
				if (max.peek().equals(vals.pop())) max.pop();
			} else {
				System.out.println(max.peek());
			}
		}
	}
	
}
