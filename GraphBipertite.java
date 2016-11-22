/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ESHA
 */
import java.util.*;

class Graph2
{
    private LinkedList<Integer>[] adj;
    private int v;
    private int e;
    Graph2(int v,int e)
    {
       adj = new LinkedList[v];
       this.v = v;
       this.e = e;
       int i;
       for(i = 0;i < v;i++)
       {
           adj[i] = new LinkedList<Integer>();
       }
    }
    void addEdge(int v,int w)
    {
        this.adj[w].add(v);
        this.adj[v].add(w);
    }
    int v()
    {
        return this.v;
    }
    int e()
    {
        return this.e;
    }
    Iterable<Integer> adj(int v)
    {
        return this.adj[v];
    }
}

class DFS2
{
    boolean[] marked;
    int[] color;
    static final int RED = 1;
    static final int BLACK = 0;
    DFS2(Graph2 G)
    {
        marked = new boolean[G.v()];
        color = new int[G.v()];
    }
    boolean bipertite(Graph2 G)
    {
        int i;
        color[0] = RED;
        if(dfs2(G,0))
            return true;
        
        return false;
    }
    boolean dfs2(Graph2 G, int v)
    {
        marked[v] = true;
        for(Integer w : G.adj(v))
        {
            if(!marked[w])
            {
                if(color[v] == RED)
                {
                    color[w] = BLACK;
                }
                else
                {
                    color[w] = RED;
                }
                if(!dfs2(G,w))
                    return false;
            }
            else
            {
                if(marked[w] && color[w] == color[v])
                {
                    return false;
                }
            }
        }
        return true;
    }
    /*void show(Graph2 G)
    {
        int i;
        for(i = 0;i < G.v();i++)
        {
            System.out.print(color[i] + " ");
        }
    }*/
}
public class GraphBipertite {
    public static void main(String args[])
    {
        Scanner obj = new Scanner(System.in);
        int vertices,edges,i;
        System.out.println("Enter number of vertices");
        vertices = obj.nextInt();
        System.out.println("Enter number of edges");
        edges = obj.nextInt();
        Graph2 G = new Graph2(vertices,edges);
        for(i = 0;i < edges;i++)
        {
            G.addEdge(obj.nextInt(),obj.nextInt());
        }
        DFS2 dfs = new DFS2(G);
        boolean flag = dfs.bipertite(G);
        //dfs.show(G);
        if(flag == true)
            System.out.println("true");
        else
            System.out.println("false");
    }
    
}
