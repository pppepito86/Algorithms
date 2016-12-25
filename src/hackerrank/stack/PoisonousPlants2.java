package hackerrank.stack;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class PoisonousPlants2 {

	public static void main(String[] args) {
//		Random r = new Random();
//		String s = "";
//		int pp = r.nextInt(10) + 1;
//		for (int i = 0; i < pp; i++) s += (r.nextInt(10) + 1) + " ";
//		System.out.println(pp);
//		System.out.println(s);
		//Scanner in = new Scanner(pp + " " + s);
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] values = new int[n];
		MinSegmentTree1 tree = new MinSegmentTree1(n);
		MaxSegmentTree1 maxTree = new MaxSegmentTree1(n);
		for (int i = 1; i <= n; i++) {
			int next = in.nextInt();
			values[i - 1] = next;
			//System.out.println(i);
			tree.replace(i, next);
		}
		int smallest = values[0];
		for (int i = 1; i < n; i++) {
			if (values[i] <= smallest) {
				smallest = values[i];
				continue;
			}
			if (values[i - 1] < values[i]) {
				maxTree.replace(i+1, 1);
				continue;
			}
			int low = 1, high = i;
			while (low < high) {
				int mid = (low + high) / 2;
				if (tree.min(mid, high) < values[i]) {
					if (tree.min(mid + 1, high) < values[i]) {
						low = mid + 1;
					} else {
						break;
					}
				} else {
					high = mid - 1;
				}
			}
			int mid = (low + high) / 2;
			int max = (int) maxTree.min(mid+1, i) + 1;
			maxTree.replace(i+1, max);
		}
		int max =  (int)maxTree.min(1, n);
		for (int i = 1; i <= n; i++) {
			//System.out.print(maxTree.min(i, i) + " ");
		}
		//System.out.println();
		System.out.println(max);
	}

}

class MinSegmentTree1 {

	private int size;
	private long[] values;

	public MinSegmentTree1(int n) {
		this.size = n;
		this.values = new long[4 * size];
		Arrays.fill(values, Integer.MAX_VALUE);
	}

	public void replace(int element, int value) {
		updateInternal(1, 1, size, element, value, true);
	}

	public void increase(int element, int value) {
		updateInternal(1, 1, size, element, value, false);
	}

	public long min(int i, int j) {
		return minInternal(1, 1, size, i, j);
	}

	private void updateInternal(int node, int left, int right, int element, int value, boolean replace) {
		if (element < left || element > right)
			return;
		if (left == right) {
			if (replace)
				values[node] = value;
			else
				values[node] += value;
			return;
		}

		int mid = (left + right) / 2;
		updateInternal(2 * node, left, mid, element, value, replace);
		updateInternal(2 * node + 1, mid + 1, right, element, value, replace);
		values[node] = Math.min(values[2 * node], values[2 * node + 1]);
	}

	private long minInternal(int node, int left, int right, int i, int j) {
		if (j < left || i > right)
			return Integer.MAX_VALUE;
		if (i <= left && right <= j)
			return values[node];

		int mid = (left + right) / 2;
		return Math.min(minInternal(2 * node, left, mid, i, j), minInternal(2 * node + 1, mid + 1, right, i, j));
	}
}

class MaxSegmentTree1 {

	private int size;
	private long[] values;

	public MaxSegmentTree1(int n) {
		this.size = n;
		this.values = new long[4 * size];
	}

	public void replace(int element, int value) {
		updateInternal(1, 1, size, element, value, true);
	}

	public void increase(int element, int value) {
		updateInternal(1, 1, size, element, value, false);
	}

	public long min(int i, int j) {
		return minInternal(1, 1, size, i, j);
	}

	private void updateInternal(int node, int left, int right, int element, int value, boolean replace) {
		if (element < left || element > right)
			return;
		if (left == right) {
			if (replace)
				values[node] = value;
			else
				values[node] += value;
			return;
		}

		int mid = (left + right) / 2;
		updateInternal(2 * node, left, mid, element, value, replace);
		updateInternal(2 * node + 1, mid + 1, right, element, value, replace);
		values[node] = Math.max(values[2 * node], values[2 * node + 1]);
	}

	private long minInternal(int node, int left, int right, int i, int j) {
		if (j < left || i > right)
			return 0;
		if (i <= left && right <= j)
			return values[node];

		int mid = (left + right) / 2;
		return Math.max(minInternal(2 * node, left, mid, i, j), minInternal(2 * node + 1, mid + 1, right, i, j));
	}
}
