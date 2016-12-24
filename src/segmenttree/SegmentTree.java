package segmenttree;

public class SegmentTree {
	
	interface MathOperation {
		long operation(long a, long b);
	}
	public static MathOperation ADDITION = (long a, long b) -> a + b;
	public static MathOperation MINIMUM = (long a, long b) -> Math.min(a, b);
	
	private int size;
	private int defaultValue;
	private long[] values;
	private MathOperation operation;

	public SegmentTree(int n, MathOperation operation, int defaultValue) {
		this.size = n > 1? Integer.highestOneBit(n-1) * 2: 1;
		this.operation = operation;
		this.defaultValue = defaultValue;
		this.values = new long[2*size];
		if (defaultValue != 0) {
			for (int i = 1; i <= n; i++) replace(i, defaultValue);
		}
	}
	
	public void replace(int element, int value) {
		updateInternal(1, 1, size, element, value, true);
	}
	
	public void increase(int element, int value) {
		updateInternal(1, 1, size, element, value, false);
	}
	
	public long compute(int i, int j) {
		return computeInternal(1, 1, size, i, j);
	}
	
	private void updateInternal(int node, int left, int right, int element, int value, boolean replace) {
		if (element < left || element > right) return;
		if (left == right) { 
			if (replace) values[node] = value; 
			else values[node] += value;
			return; 
		}
		
		int mid = (left + right) / 2;
		updateInternal(2*node, left, mid, element, value, replace);
		updateInternal(2*node+1, mid+1, right, element, value, replace);
		values[node] = operation.operation(values[2*node], values[2*node+1]);
	}

	private long computeInternal(int node, int left, int right, int i, int j) {
		if (j < left || i > right) return defaultValue;
		if (i <= left && right <= j) return values[node];
		
		int mid = (left + right) / 2;
		return operation.operation(
				computeInternal(2*node, left, mid, i, j),
				computeInternal(2*node+1, mid+1, right, i, j));
	}
	
}
