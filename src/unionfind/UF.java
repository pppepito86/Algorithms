package unionfind;

import java.util.Arrays;

public class UF {

	private int count;
	private int[] parent, size;

	public UF(int n) {
		count = n; parent = new int[n]; size = new int[n];
		for (int i = 0; i < n; i++) parent[i] = i;
		Arrays.fill(size, 1);
	}
	
	public int find(int u){
		return parent[u] = parent[u]==u?u:find(u);
	}
	
	public void union(int u, int v) {
		int ru = find(u); int rv = find(v);
		if (ru == rv) return;
		if (size[ru] >= size[rv]) {
			parent[rv] = ru; size[ru] += size[rv];
		} else {
			parent[ru] = rv; size[rv] += size[ru];
		}
		count--;
	}
	
	public boolean connected(int u, int v) {
		return find(u) == find(v);
	}
	
    public int count() {
        return count;
    }
}
