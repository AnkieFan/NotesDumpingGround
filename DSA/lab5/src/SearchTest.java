public class SearchTest {
    public static void main(String[] args) {
        GraphAdjacencyList<Integer> g = new GraphAdjacencyList<>();
        g.addVertex(-1);
        g.addVertex(0);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(-1,0);
        g.addEdge(-1,3);
        g.addEdge(3,0);
        g.addEdge(3,4);

        Search s = new Search();
        System.out.println(s.BFS(g, -1)); //[-1, 0, 3, 4]S

    }
}
