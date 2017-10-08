class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return this.next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

class MyList {
    private Node head;
    private int size;

    public MyList() {
        this.head = new Node(null);
        this.size = 0;
    }

    //Adauga un obiect in lista
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        this.size++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for(int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        this.size++;
    }

    public Object get(int index) {
        if(index < 0 && index >= this.size) {
            return null;
        } else {
            Node current = head.getNext();
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public boolean remove(int index) {
        if(index < 0 || index >= this.size) {
            return false;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        this.size--;
        return true;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        Node current = head.getNext();
        String result = "";
        while(current != null) {
            result += "[" + current.getData().toString() + "] ";
            current = current.getNext();
        }
        return result;
    }
}

class Graph {
	public ArrayList <MyList> graph;
	public int size;
	public Graph (int n)
	{
		/*
		for (int i = 0; i < n; i++)
			this.graph[i] = new MyList(); */
		this.graph = new ArrayList<MyList>();
		for (int i = 0; i < n; i++)
		{
			MyList listing = new MyList();
			graph.add(listing);
		}
		this.size = n;
	}
	
	public void add (int x, int y)
	{
		this.graph.get(x - 1).add(y - 1);
	}
	
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < this.size; ++i)
		{
			result += this.graph.get(i).toString() + "\n";
		}
		return result;
	}
	
	void DFSUtil(int v, boolean visited[])
	{
		visited[v] = true;
		System.out.print(v + 1 + " ");
		MyList listing = this.graph.get(v);
		for (int i = 0; i < listing.size(); i++)
		{
			if (!visited[(int) listing.get(i)])
				DFSUtil ((int) listing.get(i), visited);
		}
	}

	void dfs(int v)
	{
		--v;
		boolean visited[] = new boolean[size];
		DFSUtil(v, visited);
	}
}

public class Prob5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(8); 
        g.add(1, 2);
        g.add(1, 5);
        g.add(1, 8);
        g.add(2, 3);
        g.add(5, 6);
        g.add(4, 2);
        g.add(6, 3);
        g.add(6, 7);
        g.add(6, 8);
        g.add(3, 4);
        System.out.println(g);
        g.dfs(1);
	}

}
