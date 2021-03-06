package segmenttree;

public class SumSegmentTree {
	
	private int size;
	private long[] values;

	public SumSegmentTree(int n) {
		this.size = n > 1? Integer.highestOneBit(n-1) * 2: 1;
		this.values = new long[2*size];
	}
	
	public void replace(int element, int value) {
		updateInternal(1, 1, size, element, value, true);
	}
	
	public void increase(int element, int value) {
		updateInternal(1, 1, size, element, value, false);
	}
	
	public long sum(int i, int j) {
		return sumInternal(1, 1, size, i, j);
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
		values[node] = values[2*node] + values[2*node+1];
	}

	private long sumInternal(int node, int left, int right, int i, int j) {
		if (j < left || i > right) return 0;
		if (i <= left && right <= j) return values[node];
		
		int mid = (left + right) / 2;
		return sumInternal(2*node, left, mid, i, j) + sumInternal(2*node+1, mid+1, right, i, j);
	}
	
}
