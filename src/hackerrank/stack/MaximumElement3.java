package hackerrank.stack;

import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;

//https://www.hackerrank.com/challenges/maximum-element
public class MaximumElement3 {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> vals = new Stack<>();
		TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			int type = in.nextInt();
			if (type == 1) {
				int next = in.nextInt();
				vals.push(next);
				Integer times = map.get(next);
				if (times == null) times = 1;
				else times++;
				map.put(next, times);
			} else if (type == 2) {
				int next = vals.pop();
				Integer times = map.get(next);
				if (times == 1) map.remove(next);
				else map.put(next, times - 1);
			} else {
				System.out.println(map.firstKey());
			}
		}
	}

}
