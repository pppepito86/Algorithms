package hackerrank.stack;

import java.util.Scanner;
import java.util.Stack;

// https://www.hackerrank.com/challenges/poisonous-plants
public class PoisonousPlants {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack<Integer> vals = new Stack<>();
		Stack<Integer> levels = new Stack<>();
		int maxLevel = 0;
		for (int i = 1; i <= n; i++) {
			int next = in.nextInt();
			int level = 0;
			while (!vals.isEmpty()) {
				if (vals.peek() >= next) {
					vals.pop();
					level = Math.max(level, levels.pop());
				} else {
					break;
				}
			}
			if (vals.isEmpty()) level = 0;
			else level++;
			vals.push(next);
			levels.push(level);
			maxLevel = Math.max(maxLevel, level);
		}
		System.out.println(maxLevel);
	}
}
