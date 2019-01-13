package GRAPH;

import java.util.Iterator;
import java.util.LinkedList;

public class dfstime {
	int v;
	color id[];
	LinkedList<LinkedList<Integer>> arr;
	static int time = 0;
	int timein[];
	int timeout[];

	dfstime(int v) {

		int i;
		this.v = v;
		timein = new int[v];
		timeout = new int[v];
		id = new color[v];
		arr = new LinkedList<LinkedList<Integer>>();
		for (i = 0; i < v; i++) {
			arr.add(new LinkedList<Integer>());
			id[i] = color.White;
		}
	}

	void addEdge(int s, int d) {
		arr.get(s).add(d);
	}

	void dfs(int s) {
		timein[s] = time++;
		id[s] = color.Grey;
		Iterator<Integer> i = arr.get(s).iterator();
		while (i.hasNext()) {
			int x = i.next();
			if (id[x] == color.White) {
				dfs(x);
			}

		}
		timeout[s] = time++;
		System.out.println(s + "->" + timein[s] + "," + timeout[s]);
		id[s] = color.Black;
	}

	public static void main(String args[]) {
		dfstime d = new dfstime(6);
		d.addEdge(0, 1);
		d.addEdge(1, 0);
		d.addEdge(0, 4);
		d.addEdge(4, 3);
		d.addEdge(4, 2);
		d.addEdge(4, 5);
		d.addEdge(3, 5);
		d.dfs(0);
	}
}
