import java.util.*;
import java.lang.*;
import java.io.*;
public class dijkstra
{
	public static void main (String[] args)
	{
		Scanner s = new Scanner(System.in);
		System.out.println("ENTER THE NUMBER OF VERTICES : ");
		int V;
		V = s.nextInt();
		System.out.println("ENTER THE ELEMENTS OF WEIGHTED ADJACENCY MATRIX");
		int graph[][] = new int[V][V];
		for(int i = 0; i < V; i++)
			for(int j = 0; j < V; j++)
				graph[i][j] = s.nextInt();
		System.out.println("ENTER THE SOURCE NODE : ");
		int src = s.nextInt();
		dijkstra t = new dijkstra();
		int dist[] = new int[V];
		Boolean sptSet[] = new Boolean[V];
		for (int i = 0; i < V; i++)
		{
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}

		dist[src] = 0;

		for (int count = 0; count < V-1; count++)
		{
		int min = Integer.MAX_VALUE, min_index=-1;
		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min)
			{
				min = dist[v];
				min_index = v;
			}
			int u = min_index;
			sptSet[u] = true;
			for (int v = 0; v < V; v++)
				if (!sptSet[v] && graph[u][v]!=0 && dist[u] != Integer.MAX_VALUE && dist[u]+graph[u][v] < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i+" tt "+dist[i]);
    }
}
