import java.util.List;

//Graph interface
// Simplication: There are no dublicate values in T
public interface Graph<T> {
    // whether there’s an edge from x to y
    public boolean adjacent(T x, T y);
    //all vertices y s.t. there’s an edge from x to y
    public List<T> neighbors(T x);
    //adds the vertex x
    public void addVertex(T x);
    //removes the vertex x
    public void removeVertex(T x);
    //adds edge from the vertices x to y
    public void addEdge(T x, T y);
     //removes edge from the vertices x to y
    public void removeEdge(T x, T y);
}
