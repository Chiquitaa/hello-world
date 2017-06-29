//DETECT CYCLE IN UNDIRECTED GRAPH
import java.lang.*;
import java.util.*;
class Graph{
	int v;
	int edge[][]; 
	Graph(int V) { 
	this.v=V; 
	edge=new int[v][v]; 
	}  
	void addEdge(int src, int destn) { 
	edge[src][destn]=1; 
	edge[destn][src]=1; 
	}  
	void remove(int src, int destn) { 
	edge[src][destn]=0; 
	edge[destn][src]=0; 
	}
	
	void display() {
		System.out.println("The graph");
		for(int i=0; i<this.v; i++) {
			for(int j=0;j<this.v; j++) {
				System.out.print(this.edge[i][j]+" ");
			}
			System.out.println(" ");
		}
	}
	}


public class solution {
	
		static boolean hascycle(Graph graph) {
		int visited[]=new int[graph.v];
		if(dfs(graph,0,visited,0)==true) return true;
		return false;
		}
		static boolean dfs(Graph graph, int curr, int visited[], int parent) {
			System.out.println("Visited");
			for(int k=0; k<visited.length; k++) System.out.print(visited[k]+" ");
		visited[curr]=1;
		System.out.println("curr is "+curr);
		for(int j=0;j<graph.v;j++) {
		if(graph.edge[curr][j]==1) {
		if(visited[j]==2) break;
		if(visited[j]==1) {
			if(j!=parent) return true;
		}
		else if(dfs(graph,j,visited,curr)==true) return true;
		}
		}
		visited[curr]=2;
		return false;
		}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		//int vv=sc.nextInt();
		int vv=5;
		Graph graph=new Graph(vv);
		graph.addEdge(0,1);
		graph.addEdge(1,2);
		graph.addEdge(2,3);
		graph.addEdge(3,4);
		graph.addEdge(4,1);
		graph.display();
		boolean check=hascycle(graph);
		if(check==true) System.out.println("Cycle exists");
		else System.out.println("NO cycle exists");

		sc.close();
	}

}
