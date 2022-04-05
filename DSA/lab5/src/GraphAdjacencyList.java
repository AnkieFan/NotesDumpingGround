import java.util.ArrayList;
import java.util.List;

public class GraphAdjacencyList<T> implements Graph<T> {
    ArrayList<Vertex> graph = new ArrayList<>();

    @Override
    public boolean adjacent(T x, T y) {
        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i).getElement().equals(x)){
                return graph.get(i).hasEdge(y);
            }
        }
        return false;
    }

    @Override
    public List<T> neighbors(T x) {
        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i).getElement().equals(x)){
                 return graph.get(i).getEdges();
            }
        }
        return null;
    }

    @Override
    public void addVertex(T x) {
        graph.add(new Vertex<T>(x));
    }

    @Override
    public void removeVertex(T x) {
        for (int i = 0; i < graph.size(); i++) {
            graph.get(i).deleteEdge(x);
        }
        graph.remove(x);
    }

    @Override
    public void addEdge(T x, T y) {
        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i).getElement().equals(x)){
                graph.get(i).addEdge(y);
            }

            if(graph.get(i).getElement().equals(y)){
                graph.get(i).addEdge(x);
            }
        }
    }

    @Override
    public void removeEdge(T x, T y) {
        for (int i = 0; i < graph.size(); i++) {
            if(graph.get(i).getElement().equals(x)){
                graph.get(i).deleteEdge(y);
            }

            if(graph.get(i).getElement().equals(y)){
                graph.get(i).deleteEdge(x);
            }
        }
    }
}
