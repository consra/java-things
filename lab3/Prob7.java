package lab3;

class Graph {
	int [][] matrix;
	int n;
	int infinit = 9500;
	
	public Graph (int nodes)
	{
		this.n = nodes;
		matrix = new int[nodes][nodes];
		for (int i = 0; i < nodes; ++i)
		{
			for (int j = 0; j < nodes; ++j)
			{
				if (i == j)
					this.matrix[i][j] = 0;
				else
					this.matrix[i][j] = this.infinit;
			}
		}
	}
	
	public int getSize ()
	{
		int nodes = 0;
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				if (matrix[i][j] != 0 && matrix[i][j] != infinit)
					nodes++;
			}
		}
		return nodes;
	}
	
	public void addArc (int v, int w, int cost)
	{
		matrix[v][w] = cost;
	}
	
	public boolean isArc (int v, int w)
	{
		if (this.matrix[v][w] == 0 || this.matrix[v][w] == this.infinit)
			return false;
		else
			return true;
	}
	
	public String toString ()
	{
		String result = "";
		for (int i = 0; i < n; ++i)
		{
			for (int j = 0; j < n; ++j)
			{
				result = result + matrix[i][j];
				if (j == n - 1)
					result = result + "\n";
				else
					result = result + " ";
			}
		}
		return result;
	}
	
	public int[][] floydWarshall() {
		int result[][];
		result = new int[this.n][this.n];
		int k, i, j;
		for(i = 0; i < this.n; i++) {
			for(j = 0; j < this.n; j++) {
				if(i == j) {
					result[i][j] = 0;
				} else if(this.isArc(i, j)) {
					result[i][j] = this.matrix[i][j];
				} else {
					result[i][j] = infinit;
				}
			}
		}
		for(k = 0; k < this.n; k++) {
			for(i = 0; i < this.n; i++) {
				for(j = 0; j < this.n; j++) {
					int dist;
					dist = result[i][k] + result[k][j];
					if(result[i][j] > dist) {
						result[i][j] = dist;
					}
				}
			}
		}
		return result;
	}
}

public class Prob7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(8);
        g.addArc(4, 6, 2);
        g.addArc(4, 5, 3);
        g.addArc(5, 1, 1);
        g.addArc(1, 2, 5);
        g.addArc(2, 5, 7);
        g.addArc(2, 3, 6);
        g.addArc(3, 4, 3);
        g.addArc(0, 6, 15);
        g.addArc(0, 4, 1);
        g.addArc(5, 0, 6);
        g.addArc(7, 4, 2);
        g.addArc(7, 5, 4);
        //System.out.println(g);
        int[][] kek = g.floydWarshall();
        for (int i = 0; i < g.n; ++i)
        {
        	for (int j = 0; j < g.n; ++j)
        	{
        		System.out.printf("%d", kek[i][j]);
        		if (j == g.n - 1)
        			System.out.printf("\n");
        		else
        			System.out.printf(" ");
        	}
        }
	}

}
