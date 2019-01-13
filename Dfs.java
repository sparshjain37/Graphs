
	int v;
	color id[];
	LinkedList<LinkedList<Integer>> arr;
	DFS(int v)
	{
		int i;
		this.v=v;
		id=new color[v];
		arr=new LinkedList<LinkedList<Integer>>();
		for(i=0;i<v;i++)
		{
			arr.add(new LinkedList<Integer>());
			id[i]=color.White;
		}
	}
	void addEdge(int s,int d)
	{
		arr.get(s).add(d);
	}
	void dfs(int s)
	{
		id[s]=color.Grey;
		Iterator<Integer> i=arr.get(s).iterator();
		while(i.hasNext())
		{
			int x=i.next();
			if(id[x]==color.White)
			{
				dfs(x);
			}
			
		}
		System.out.println(s);
		id[s]=color.Black;
	}
	public static void main(String args[])
	{
		DFS d=new DFS(6);
		d.addEdge(0, 1);
		d.addEdge(1, 0);
		d.addEdge(0, 4);
		d.addEdge(4, 3);
		d.addEdge(4, 2);
		d.addEdge(4, 5);
		d.addEdge(3, 5);
		d.dfs(0);
		}
