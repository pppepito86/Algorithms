package hackerrank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

//https://www.hackerrank.com/challenges/and-xor-or
public class AndXorOr2 {
	
	static class Node {
		int idx, prev, next, val;
		public Node(int i, int v) {idx = i; prev = i-1; next = i+1; val = v;}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Node[] nodes = new Node[n+2];
		nodes[0] = new Node(0, -1); nodes[0].prev = 0;
		nodes[n+1] = new Node(n+1, -1); nodes[n+1].next = n+1;
		Integer[] a = new Integer[n];
		int[] b = new int[n];
		for (int i = 1; i <= n; i++) {
			a[i-1] = i;
			b[i-1] = in.nextInt();
			nodes[i] = new Node(i, b[i-1]);
		}
		Arrays.sort(a, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return b[o2-1] - b[o1-1];
			}
		});
		int res = 0;
		for (int idx : a) {
			Node node = nodes[idx];
			if ((node.val ^ nodes[node.prev].val) > res) res = node.val ^ nodes[node.prev].val;
			if ((node.val ^ nodes[node.next].val) > res) res = node.val ^ nodes[node.next].val;
			nodes[node.prev].next = node.next;
			nodes[node.next].prev = node.prev;
		}
		System.out.println(res);
	}

}
