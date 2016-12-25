package hackerrank.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

//https://www.hackerrank.com/challenges/largest-rectangle
public class LargestRectangle {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n+2];
		for (int i = 1; i <= n; i++) a[i] = in.nextInt();
		Stack<Integer> mins = new Stack<>();
		Stack<Integer> indexes = new Stack<>();
		long max = 0;
		for (int i = 0; i < n+2; i++) {
			int next = a[i];
			while (!mins.isEmpty()) {
				if (next < mins.peek()) {
					int val = mins.pop(); indexes.pop();
					int left = indexes.peek();
					long current = (i - left - 1) * val;
					if (current > max) max = current;
				} else {
					break;
				}
			}
			mins.push(next);
			indexes.push(i);
		}
		System.out.println(max);
	}

}
