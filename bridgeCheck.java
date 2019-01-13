package GraphBridge;

import java.util.Iterator;
import java.util.LinkedList;

enum color {
	white, grey, black;
}

public class Graph {
	int v;
	color id[];
	int parent[];
	int dep[];
	int fup[];
	int outdeg[];
	LinkedList<LinkedList<Integer>> arr;

	Graph(int v) {
		outdeg = new int[v];
		dep = new int[v];
		fup = new int[v];
		id = new color[v];
		parent = new int[v];
		this.v = v;
		arr = new LinkedList<LinkedList<Integer>>();
		for (int i = 0; i < v; i++) {
			id[i] = color.white;
			arr.add(new LinkedList<Integer>());
			outdeg[i] = 0;
		}
	}

	void findBridge(int s, int p, int time) {
		id[s] = color.grey;
		dep[s] = time;
		fup[s] = time;
		parent[s] = p;
		Iterator<Integer> itr = arr.get(s).iterator();
		while (itr.hasNext()) {
			int x = itr.next();
			if (id[x] == color.white) {
				findBridge(x, s, time + 1);
				fup[s] = Math.min(fup[s], fup[x]);
			}
			else if (parent[s] != x && id[x] == color.grey) {
				fup[s] = Math.min(fup[s], dep[x]);
			}

			System.out.println(s+" -> "+fup[s]+","+dep[s]);
		}

	}

	void printBridge() {
		int s = 0;

		Iterator<LinkedList<Integer>> itr = arr.iterator();
		while (itr.hasNext()) {

			Iterator<Integer> itr2 = itr.next().iterator();
			while (itr2.hasNext()) {
				int x = itr2.next();
				if (fup[x] > dep[s]) {
					System.out.println(x + " " + s);
				}

			}
			s++;
		}
	}

	void addEdge(int s, int d) {
		arr.get(s).add(d);
	}

	public static void main(String args[]) {
		Graph g1 = new Graph(6);
		g1.addEdge(0, 1);
		g1.addEdge(0, 2);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 4);
		g1.addEdge(4, 5);
		g1.addEdge(5, 3);
		g1.findBridge(0, -1, 1);
		
	}

}
