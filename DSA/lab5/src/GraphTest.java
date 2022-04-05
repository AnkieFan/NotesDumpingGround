public class GraphTest {
    public static void main(String[] args) {
        GraphAdjacencyList<Integer> g = new GraphAdjacencyList<>();
        g.addVertex(-1);
        g.addVertex(5);
        g.addVertex(3);
        g.addVertex(4);

        g.addEdge(-1,3);
        g.addEdge(-1,5);
        g.addEdge(-1,4);
        g.addEdge(3,4);


        System.out.println(g.adjacent(-1,5)); // True
        System.out.println(g.adjacent(-1,3)); // True
        System.out.println(g.adjacent(-1,4)); // True
        System.out.println(g.adjacent(3,4)); // True
        System.out.println(g.adjacent(3,5)); // False
        System.out.println(g.adjacent(4,5)); // False
        System.out.println(g.adjacent(5,-1)); // True
        System.out.println(g.adjacent(3,-1)); // True
        System.out.println(g.adjacent(4,-1)); // True
        System.out.println(g.adjacent(4,3)); // True
        System.out.println(g.adjacent(5,3)); // False
        System.out.println(g.adjacent(5,4)); // False

        System.out.println("========= Remove Edge (4,3) ===========");
        g.removeEdge(4,3);
        System.out.println(g.adjacent(4,3)); // False
        System.out.println(g.adjacent(3,4)); // False

        System.out.println("========= Remove Vertex 4 ===========");
        g.removeVertex(4);
        System.out.println(g.adjacent(-1,4)); // False
        System.out.println(g.adjacent(3,4)); // False
        System.out.println(g.adjacent(4,5)); // False
        System.out.println(g.adjacent(4,-1)); // False
        System.out.println(g.adjacent(4,3)); // False
        System.out.println(g.adjacent(5,4)); // False

    }
}
