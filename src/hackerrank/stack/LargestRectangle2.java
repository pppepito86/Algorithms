package hackerrank.stack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.TreeSet;

//https://www.hackerrank.com/challenges/largest-rectangle
public class LargestRectangle2 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Integer[] idx = new Integer[n];
		int[] vals = new int[n];
		for (int i = 0; i < n; i++) {
			idx[i] = i;
			vals[i] = in.nextInt();
		}
		Arrays.sort(idx, new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return vals[o1] - vals[o2];
			}
		});
		long max = 0;
		TreeSet<Integer> removed = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			int val = vals[idx[i]];
			Integer first = removed.floor(idx[i] - 1);
			if (first == null) first = -1;
			Integer last = removed.ceiling(idx[i] + 1);
			if (last == null) last = n;
			long current = (last - first - 1) * val;
			if (current > max) max = current;
			removed.add(idx[i]);
		}
		System.out.println(max);
	}

}
