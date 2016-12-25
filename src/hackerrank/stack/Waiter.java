package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;


public class Waiter {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt(); int q = in.nextInt();
		Stack<Integer> last = new Stack<>();
		for (int i = 0; i < n; i++) last.push(in.nextInt());
		Stack<Integer> current = new Stack<>();
		Stack<Integer>[] b = new Stack[q];
		for (int i = 0; i < q; i++) b[i] = new Stack<>();
		int[] p = getPrimes(q);
		for (int i = 0; i < q; i++) {
			while (!last.isEmpty()) {
				int next = last.pop();
				if (next % p[i] == 0) b[i].push(next);
				else current.push(next);
			}
			last = current;
			current = new Stack<>();
		}
		for (int i = 0; i < q; i++) {
			while (!b[i].isEmpty()) System.out.println(b[i].pop());
		}
		while (!last.isEmpty()) System.out.println(last.pop());

	}

	private static int[] getPrimes(int q) {
		int[] p = new int[q];
		int idx = 0;
		int n = 2;
		while (idx < q) {
			while (!isPrime(n)) n++;
			p[idx++] = n++;
		}
		return p;
	}

	private static boolean isPrime(int n) {
		for (int i = 2; i*i <= n; i++) {
			if (n%i == 0) return false;
		}
		return true;
	}

}
