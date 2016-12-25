package hackerrank.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/equal-stacks
public class EqualStacks {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n1 = in.nextInt(); int n2 = in.nextInt(); int n3 = in.nextInt();
		int h1 = 0, h2 = 0, h3 = 0;
		Deque<Integer> d1 = new LinkedList<>();
		for (int i = 0; i < n1; i++) {int next = in.nextInt(); d1.addFirst(next); h1 += next;}
		Deque<Integer> d2 = new LinkedList<>();
		for (int i = 0; i < n2; i++) {int next = in.nextInt(); d2.addFirst(next); h2 += next;}
		Deque<Integer> d3 = new LinkedList<>();
		for (int i = 0; i < n3; i++) {int next = in.nextInt(); d3.addFirst(next); h3 += next;}
		while (h1 != h2 || h1 != h3) {
			if (h1 >= h2 && h1 >= h3) {
				h1 -= d1.removeLast();
			} else if (h2 >= h1 && h2 >= h3) {
				h2 -= d2.removeLast();
			} else {
				h3 -= d3.removeLast();
			}
		}
		System.out.println(h1);
	}

}
