//Detect cycle in undirected graph
import java.lang.*;
import java.util.*;

class Solution {
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
}

boolean hascycle(Graph graph) {
int visited=new int[graph.v];
if(dfs(graph,0)==true) return true;
return false;
}
boolean dfs(Graph graph, int curr) {
visited[curr]=1;for(int j=0;j<graph.v;j++) {
if(graph.edge[curr][j]==1) {
if(visited[j]==2) continue;
if(visited[j]==1) return true;
else if(dfs(graph,j)==true) 
return true;
}}
visited[curr]=2;return false;}
public static void main(String args[]) {
Scanner sc=new Scanner(System.in);
int vv=sc.nextInt();
Graph graph=new Graph(vv);
graph.addEdge(0,1);
graph.addEdge(0,2);
graph.addEdge(0,3);
graph.addEdge(2,1);
graph.addEdge(4,3);
boolean check=hascycle(graph);
if(check) System.out.println("Cycle exists");
else System.out.println("No cycle exists");
}
}
