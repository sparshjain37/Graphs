package GRAPH;

import java.util.Iterator;
import java.util.LinkedList;

public class DfsLoopCheck {
	int v;
	color id[];
	int parent[];
	LinkedList<LinkedList<Integer>> arr;
	DfsLoopCheck(int v)
	{
		this.v=v;
		id=new color[v];
		arr=new LinkedList<LinkedList<Integer>>();
		parent=new int[v];
		for(int i=0;i<v;i++)
		{
			arr.add(new LinkedList<>());
			id[i]=color.White;
		}
	}
	void addEdge(int s,int d)
	{
		arr.get(s).add(d);
	}
	int dfsLoop(int start,int p)
	{
		id[start]=color.Grey;
		parent[start]=p;
		Iterator<Integer>itr=arr.get(start).iterator();
		while(itr.hasNext())
		{
			int x=itr.next();
			if(id[x]==color.White)
			{
				 return dfsLoop(x,start);
			}
			else if(id[x]==color.Grey && parent[x]!=start)
			{
				return 1;
			}
		}
		
		id[start]=color.Black;
return 0;
	}
	public static void main(String args[])
	{
		DfsLoopCheck d2=new DfsLoopCheck(6);                     
		d2.addEdge(0, 1);
		d2.addEdge(1, 2);
		d2.addEdge(2, 0);
		
			int x=d2.dfsLoop(0,-1);
			System.out.println(x);
		
	}
}
