package datastructure.graph;

import java.util.LinkedList;

/**
 * Adjacency list represents Graph
 *
 * Pros: Saves space O(|V|+|E|) . In the worst case, there can be C(V, 2) number of edges in a graph thus consuming O(V^2) space. Adding a vertex is easier.
 *
 * Cons: Queries like whether there is an edge from vertex u to vertex v are not efficient and can be done O(V).
 *
 *
 *
 * Operations
 * The basic operations provided by a graph data structure G usually include:[1]
 *
 * adjacent(G, x, y): tests whether there is an edge from the vertex x to the vertex y;
 * neighbors(G, x, y): lists all vertices y such that there is an edge from the vertex x to the vertex y;
 * add_vertex(G, x): adds the vertex x, if it is not there;
 * remove_vertex(G, x): removes the vertex x, if it is there;
 * add_edge(G, x, y): adds the edge from the vertex x to the vertex y, if it is not there;
 * remove_edge(G, x, y): removes the edge from the vertex x to the vertex y, if it is there;
 * get_vertex_value(G, x): returns the value associated with the vertex x;
 * set_vertex_value(G, x, v): sets the value associated with the vertex x to v.
 * Structures that associate values to the edges usually also provide:[1]
 *
 * get_edge_value(G, x, y): returns the value associated with the edge (x, y);
 * set_edge_value(G, x, y, v): sets the value associated with the edge (x, y) to v.
 *
 *
 * @author Michael Liu
 */
public class GFG
{
  // A user define class to represent a graph.
  // A graph is an array of adjacency lists.
  // Size of array will be V (number of vertices
  // in graph)
  static class Graph
  {
    int V;
    LinkedList<Integer>[] adjListArray;

    // constructor
    Graph(int V)
    {
      this.V = V;

      // define the size of array as
      // number of vertices
      adjListArray = new LinkedList[V];

      // Create a new list for each vertex
      // such that adjacent nodes can be stored
      for(int i = 0; i < V ; i++){
        adjListArray[i] = new LinkedList<>();
      }
    }
  }

  static class Vertex
  {
    int src;
  }

  static class Edge
  {
    int weight;
  }


  // Adds an edge to an undirected graph
  static void addEdge(Graph graph, int src, int dest)
  {
    // Add an edge from src to dest.
    graph.adjListArray[src].add(dest);

    // Since graph is undirected, add an edge from dest
    // to src also
    graph.adjListArray[dest].add(src);
  }

  // A utility function to print the adjacency list
  // representation of graph
  static void printGraph(Graph graph)
  {
    for(int v = 0; v < graph.V; v++)
    {
      System.out.println("Adjacency list of vertex "+ v);
      System.out.print("head");
      for(Integer pCrawl: graph.adjListArray[v]){
        System.out.print(" -> "+pCrawl);
      }
      System.out.println("\n");
    }
  }

  // Driver program to test above functions
  public static void main(String args[])
  {
    // create the graph given in above figure
    int V = 5;
    Graph graph = new Graph(V);
    addEdge(graph, 0, 1);
    addEdge(graph, 0, 4);
    addEdge(graph, 1, 2);
    addEdge(graph, 1, 3);
    addEdge(graph, 1, 4);
    addEdge(graph, 2, 3);
    addEdge(graph, 3, 4);

    // print the adjacency list representation of
    // the above graph
    printGraph(graph);
  }
}