import java.util.LinkedList;

public class Vertex<T> {
    private T element;
    private LinkedList<T> edges;

    public Vertex(T element) {
        this.element = element;
        edges = new LinkedList<>();
    }

    public void addEdge(T element) {
        edges.add(element);
    }

    public boolean deleteEdge(T e) {
        if(e == element){
            edges = new LinkedList<>();
            return true;
        }
        return edges.remove(e);
    }

    public boolean hasEdge(T y){
        return edges.contains(y);
    }

    public LinkedList<T> getEdges() {
        return edges;
    }

    public T getElement() {
        return element;
    }

    public static void main(String[] args) {
        int i = 2147483647;
        System.out.println(i+1);
        System.out.println(Integer.MAX_VALUE);
    }
}
