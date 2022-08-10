package com.ms.hard.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Undirected graph representation
 */
public class Graph {

    private int V;
    private int E;
    private LinkedList<Integer>[] adjMatrix;

    public Graph(int nodes){
        this.V=nodes;
        this.E=0;
        this.adjMatrix = new LinkedList[nodes];
        for(int v=0;v < V; v++){
            adjMatrix[v] = new LinkedList<>();
        }
    }

    public void addEdge(int u, int v){
        adjMatrix[u].add(v);
        adjMatrix[v].add(u);
        E++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(V + " vertices "+ E + " Edges "+"\n");
        for(int v=0;v< V ;v++){
            sb.append(v + ":");
            for(int w : adjMatrix[v]){
                sb.append(w + " ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public void bfs(int source){
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        visited[source] = true;
        q.offer(source);

        while(!q.isEmpty()){
            int u = q.poll();
            System.out.print(u+ " ");
            for(int v: adjMatrix[u]){
                if(!visited[v]){
                    visited[v]=true;
                    q.offer(v);
                }
            }
        }
    }

    //&& cp -R ./build/* ../main/resources/public/
    public void dfs(int source){
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        stack.push(source);
        while(!stack.isEmpty()){
            int u = stack.pop();
            if(!visited[u]){
                visited[u]=true;
                System.out.print(u + " ");
                for(int v: adjMatrix[u]){
                    if(!visited[v]){
                        stack.push(v);
                    }
                }
            }

        }

    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(3,0);
        g.addEdge(2,4);

        System.out.println(g);
        System.out.println("BFS -> ");
        g.bfs(0);
        System.out.println("\nDFS -> ");
        g.dfs(0);
    }
}
